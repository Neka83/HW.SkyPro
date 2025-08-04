package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок не может быть пустым");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Контент не может быть пустым");
        }
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + ": " + content;
    }
}