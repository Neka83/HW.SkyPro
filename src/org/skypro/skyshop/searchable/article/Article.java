package org.skypro.skyshop.searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String content;

    public Article(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Содержание статьи не может быть пустым");
        }
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return content;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return "Статья: " + content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}