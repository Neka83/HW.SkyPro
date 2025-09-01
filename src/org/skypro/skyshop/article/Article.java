package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

Homework-Exceptions
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

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
 Homework-skypro.packages&classes
    }

    @Override
    public String getSearchTerm() {
 Homework-Exceptions
        return title + " " + content;

        return toString();
 Homework-skypro.packages&classes
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
Homework-Exceptions
    public String toString() {
        return title + ": " + content;

    public String getName() {
        return title;
Homework-skypro.packages&classes
    }
}