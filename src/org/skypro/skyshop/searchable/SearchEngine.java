package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    public List<Searchable> search(String query, List<Searchable> items) throws BestResultNotFound {
        List<Searchable> result = new ArrayList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                result.add(item);
            }
        }

        if (result.isEmpty()) {
            throw new BestResultNotFound(query);
        }

        return result;
    }

    public Searchable findBestResult(String search, List<Searchable> items) throws BestResultNotFound {
        int max = 0;
        Searchable result = null;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase());
            if (count > max) {
                max = count;
                result = item;
            }
        }

        if (result == null) {
            throw new BestResultNotFound(search);
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