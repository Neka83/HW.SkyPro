package org.skypro.skyshop.searchable;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(Searchable[] items) {
        this.items = items;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int index = 0;

        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[index++] = item;
                if (index == results.length) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestResult(String query) throws BestResultNotFound {
        int maxCount = 0;
        Searchable best = null;

        for (Searchable item : items) {
            int count = item.countOccurrences(query);
            if (count > maxCount) {
                maxCount = count;
                best = item;
            }
        }

        if (best == null) {
            throw new BestResultNotFound(query);
        }

        return best;
    }
}