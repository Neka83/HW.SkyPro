package org.skypro.skyshop.searchable;

public class Article implements Searchable {
    private String content;

    public Article(String content) {
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return content;
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String toString() {
        return "Статья: " + content;
    }
}