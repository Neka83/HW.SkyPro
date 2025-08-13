package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProduct(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int total = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product p : entry.getValue()) {
                System.out.println(p.getName() + ": " + p.getPrice());
                total += p.getPrice();
            }
        }
        System.out.println("Итого: " + total);
    }

    public boolean contains(String name) {
        return products.containsKey(name);
    }

    public int getTotalPrice() {
        return products.values().stream().flatMap(List::stream).mapToInt(Product::getPrice).sum();
    }

    public int countSpecialProducts() {
        return (int) products.values().stream().flatMap(List::stream).filter(Product::isSpecial).count();
    }
}