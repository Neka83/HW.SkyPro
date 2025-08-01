package org.skypro.skyshop.searchable;

public interface Searchable {
    int countOccurrences(String word);
    String getSearchTerm();
    String getContentType();
}