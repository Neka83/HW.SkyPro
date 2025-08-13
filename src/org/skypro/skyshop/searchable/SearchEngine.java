package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine(List<Searchable> items) {
        this.items = items;
    }

    public Map<String, Searchable> search(String keyword) {
        Map<String, Searchable> results = new TreeMap<>();
        if (keyword == null || keyword.isBlank()) return results;

        String lowerKeyword = keyword.toLowerCase();
        for (Searchable item : items) {
            String content = item.getSearchTerm();
            if (content != null && content.toLowerCase().contains(lowerKeyword)) {
                results.put(item.getSearchTerm(), item);
            }
        }
        return results;
    }
}