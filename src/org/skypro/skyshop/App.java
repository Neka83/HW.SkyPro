package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.searchable.Article;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Яблоко", 100));
        basket.addProduct(new SimpleProduct("Банан", 120));
        basket.addProduct(new SimpleProduct("Молоко", 80));
        basket.addProduct(new SimpleProduct("Хлеб", 50));
        basket.addProduct(new FixPriceProduct("Сыр"));

        basket.printBasket();
        System.out.println("Специальных товаров: " + basket.countSpecialProducts());
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        System.out.println("Есть ли 'Хлеб'? " + basket.contains("Хлеб"));
        System.out.println("Есть ли 'Масло'? " + basket.contains("Масло"));

        // Удаление существующего продукта
        List<Product> removed = basket.removeProductByName("Яблоко");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалены:");
            for (Product p : removed) {
                System.out.println(p.getName() + ": " + p.getPrice());
            }
        }

        basket.printBasket();

        // Удаление несуществующего
        List<Product> notFound = basket.removeProductByName("Масло");
        if (notFound.isEmpty()) {
            System.out.println("Список пуст");
        }

        basket.printBasket();

        // Поиск
        List<Searchable> items = new ArrayList<>();
        items.add(new Article("Молоко молоко"));
        items.add(new Article("Хлеб и масло"));
        items.add(new Article("Подарочный набор"));

        SearchEngine engine = new SearchEngine();

        try {
            Searchable best = engine.findBestResult("молоко", items);
            System.out.println("Лучший результат по запросу 'молоко': " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        try {
            List<Searchable> results = engine.search("подарок", items);
            if (results.isEmpty()) {
                System.out.println("Результаты поиска не найдены");
            } else {
                System.out.println("Результаты поиска:");
                for (Searchable s : results) {
                    System.out.println(s.getSearchTerm());
                }
            }
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}