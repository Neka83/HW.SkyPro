package org.skypro.skyshop.searchable;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < searchableItems.length) {
            searchableItems[size++] = item;
        } else {
            System.out.println("Невозможно добавить: хранилище переполнено");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (int i = 0; i < size; i++) {
            Searchable item = searchableItems[i];
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultIndex++] = item;
                if (resultIndex >= 5) {
                    break;
                }
            }
        }

        return results;
    }
}