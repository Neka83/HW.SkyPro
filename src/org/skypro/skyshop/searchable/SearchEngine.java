package org.skypro.skyshop.search;

import org.skypro.skyshop.searchable.Searchable;
import java.util.*;

public class SearchEngine {
    private final Set<Searchable> items;

    public SearchEngine() {
        this.items = new HashSet<>();
    }

    public void addItem(Searchable item) {
        items.add(item); // HashSet не добавит дубликаты
    }

    public Set<Searchable> search(String keyword) {
        if (keyword == null || keyword.isBlank()) return new TreeSet<>(SearchableComparators.SEARCHABLE_COMPARATOR);

        String lowerKeyword = keyword.toLowerCase();
        Set<Searchable> results = new TreeSet<>(SearchableComparators.SEARCHABLE_COMPARATOR);

        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(lowerKeyword)) {
                results.add(item);
            }
        }
        return results;
    }
}