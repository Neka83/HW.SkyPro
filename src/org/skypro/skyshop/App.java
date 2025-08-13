package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Article;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // Корзина
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 100));
        basket.addProduct(new FixPriceProduct("Сыр"));
        basket.addProduct(new FixPriceProduct("Молоко"));
        basket.addProduct(new SimpleProduct("Хлеб", 50));

        System.out.println("Корзина:");
        basket.printBasket();

        // Удаление продукта
        List<Product> removed = basket.removeProduct("Хлеб");
        System.out.println("\nПосле удаления Хлеба:");
        if (removed.isEmpty()) System.out.println("Продукт не найден");
        basket.printBasket();

        // Поиск
        List<Searchable> items = new ArrayList<>();
        items.add(new FixPriceProduct("Сыр"));
        items.add(new Article("Рецепт сыра"));
        items.add(new Article("Фрукты: яблоки и бананы"));

        SearchEngine searchEngine = new SearchEngine(items);
        String query = "сыр";

        System.out.println("\nРезультаты поиска по запросу \"" + query + "\":");
        Map<String, Searchable> results = searchEngine.search(query);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            results.forEach((name, item) -> System.out.println(name + " → " + item.getSearchTerm()));
        }
    }
}