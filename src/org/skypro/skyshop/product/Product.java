package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final int basePrice;

    public Product(String name, int basePrice) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public int countOccurrences(String word) {
        if (word == null || word.isBlank()) {
            return 0;
        }
        // Подсчёт количества вхождений word в name (без учёта регистра)
        return getName().toLowerCase().split(word.toLowerCase(), -1).length - 1;
    }
}