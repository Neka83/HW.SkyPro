package org.skypro.skyshop.searchable;

Homework-Exceptions
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
 Homework-skypro.packages&classes
    }
}