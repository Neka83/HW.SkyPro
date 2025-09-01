package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
Homework-Exceptions
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;
import java.util.Arrays;
Homework-skypro.packages&classes

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

        Homework-Exceptions


        Homework-skypro.packages&classes
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        basket.addProduct(extra); // сообщение о переполнении

        Homework-Exceptions
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


        basket.addProduct(extra);


        basket.printBasket();


        System.out.println("Общая стоимость: " + basket.getTotalPrice());


        System.out.println("Есть ли 'Хлеб'? " + basket.containsProduct("Хлеб"));
        System.out.println("Есть ли 'Масло'? " + basket.containsProduct("Масло"));

        Homework-polymorphism


        // Очистка корзины. Имеются изменения
        Homework-skypro.packages&classes
        basket.clearBasket();


        basket.printBasket();


        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        System.out.println("Есть ли 'Яблоко'? " + basket.containsProduct("Яблоко"));

        SearchEngine engine = new SearchEngine(10);


        engine.add(new SimpleProduct("Молоко", 80));
        engine.add(new Article("О молоке", "Молоко полезно для костей"));
        engine.add(new SimpleProduct("Хлеб", 50));
        engine.add(new Article("О хлебе", "Хлеб — всему голова"));
        engine.add(new DiscountProduct("Скидочное молоко", 100, 30));
        engine.add(new FixPriceProduct("Подарочная коробка"));


        Searchable[] found = engine.search("молоко");

        System.out.println("\nРезультаты поиска по запросу 'молоко':");
        for (Searchable item : found) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
        engine.add(new Article("Про яблоки", "Яблоки бывают красные и зелёные"));
        engine.add(new Article("Полезные продукты", "Молоко, хлеб и сыр"));

        System.out.println("\nПоиск по слову 'хлеб':");
        Searchable[] foundBread = engine.search("хлеб");
        System.out.println(Arrays.toString(foundBread));

        System.out.println("\nПоиск по слову 'яблоки':");
        Searchable[] foundApple = engine.search("яблоки");
        System.out.println(Arrays.toString(foundApple));

        System.out.println("\nПоиск по слову 'подарок':");
        Searchable[] foundGift = engine.search("подарок");
        System.out.println(Arrays.toString(foundGift));
        Homework-skypro.packages&classes
    }
}