package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[size++] = product;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += products[i].getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());

    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;

    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;

    }
}
