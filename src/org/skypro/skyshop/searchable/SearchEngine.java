package org.skypro.skyshop.searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(Searchable[] items) {
        this.items = items;
    }

    public Searchable findBestResult(String query) throws BestResultNotFound {
        int max = 0;
        Searchable result = null;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), query.toLowerCase());
            if (count > max) {
                max = count;
                result = item;
            }
        }

        if (result == null || max == 0) {
            throw new BestResultNotFound(query);
        }

        return result;
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}