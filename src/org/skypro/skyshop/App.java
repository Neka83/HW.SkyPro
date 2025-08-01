package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

public class App {
    public static void main(String[] args) {
        // Проверка валидации
        try {
            Product p1 = new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }

        try {
            Product p2 = new SimpleProduct("Яблоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }

        try {
            Product p3 = new DiscountedProduct("Молоко", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }

        // ======= Демонстрация корзины ========
        Product apple = new SimpleProduct("Яблоко", 100);
        Product banana = new SimpleProduct("Банан", 120);
        Product milk = new SimpleProduct("Молоко", 80);
        Product bread = new SimpleProduct("Хлеб", 50);
        Product cheese = new SimpleProduct("Сыр", 200);
        Product extra = new SimpleProduct("Доп. товар", 150);

        Product discountApple = new DiscountedProduct("Яблоко со скидкой", 100, 20);
        Product fixedGift = new FixPriceProduct("Подарок");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        basket.addProduct(extra); // сообщение о переполнении

        basket.printBasket();
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        System.out.println("Есть ли 'Хлеб'? " + basket.containsProduct("Хлеб"));
        System.out.println("Есть ли 'Масло'? " + basket.containsProduct("Масло"));

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        System.out.println("Есть ли 'Яблоко'? " + basket.containsProduct("Яблоко"));

        // ======= Демонстрация поиска ========
        Product p4 = new SimpleProduct("Хлеб хлеб хлеб", 50);
        Product p5 = new DiscountedProduct("Молоко молоко", 100, 10);
        Article a1 = new Article("О молоке", "Молоко полезно. Молоко — это жизнь.");

        Searchable[] content = new Searchable[] { p4, p5, a1 };
        SearchEngine engine = new SearchEngine(content);

        try {
            Searchable best = engine.findBestResult("молоко");
            System.out.println("Лучший результат по запросу 'молоко': " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        try {
            Searchable best = engine.findBestResult("подарок");
            System.out.println("Лучший результат по запросу 'подарок': " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}