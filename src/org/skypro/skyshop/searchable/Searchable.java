package org.skypro.skyshop.searchable;

public interface Searchable {
 Homework-Exceptions
    String getSearchTerm();
    String getContentType();


    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " — тип " + getContentType();
    }
 Homework-skypro.packages&classes
}