package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        return removed;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }

        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean contains(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int getTotalPrice() {
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public int countSpecialProducts() {
        return (int) products.stream().filter(Product::isSpecial).count();
    }
}