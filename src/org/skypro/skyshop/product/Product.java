package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод, который должны реализовать дочерние классы
    public abstract int getPrice();

    // Метод для определения специальных товаров, по умолчанию false
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }
}
