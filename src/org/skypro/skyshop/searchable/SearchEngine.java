package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;
import org.skypro.skyshop.search.SearchableComparators;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public void addItem(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return new TreeSet<>(SearchableComparators.SEARCHABLE_COMPARATOR);
        }

        String lowerKeyword = keyword.toLowerCase();


        return items.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toCollection(() -> new TreeSet<>(SearchableComparators.SEARCHABLE_COMPARATOR)));
    }
}