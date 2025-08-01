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
            throw new IllegalArgumentException("Содержимое не может быть пустым");
        }
        this.title = title;
        this.content = content;
    }

    @Override
    public int countOccurrences(String word) {
        if (word == null || word.isBlank()) {
            return 0;
        }
        String lowerWord = word.toLowerCase();
        String lowerContent = content.toLowerCase();
        int count = 0;
        int index = lowerContent.indexOf(lowerWord);
        while (index != -1) {
            count++;
            index = lowerContent.indexOf(lowerWord, index + lowerWord.length());
        }
        return count;
    }

    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}