package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.searchable.Article;
import org.skypro.skyshop.searchable.Searchable;
import java.util.Set;

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
        basket.removeProduct("Хлеб");
        System.out.println("\nПосле удаления Хлеба:");
        basket.printBasket();

        // Поиск
        SearchEngine engine = new SearchEngine();
        engine.addItem(new FixPriceProduct("Сыр"));
        engine.addItem(new Article("Рецепт сыра"));
        engine.addItem(new Article("Фрукты: яблоки и бананы"));

        String query = "сыр";
        System.out.println("\nРезультаты поиска по запросу \"" + query + "\":");

        Set<Searchable> results = engine.search(query);
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable s : results) {
                System.out.println(s.getSearchTerm());
            }
        }
    }
}