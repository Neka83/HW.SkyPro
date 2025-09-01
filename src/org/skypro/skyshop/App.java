package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 100);
        Product banana = new SimpleProduct("Банан", 120);
        Product milk = new SimpleProduct("Молоко", 80);
        Product bread = new SimpleProduct("Хлеб", 50);
        Product cheese = new SimpleProduct("Сыр", 200);
        Product extra = new SimpleProduct("Доп. товар", 150);

        Product discountApple = new DiscountProduct("Яблоко со скидкой", 100, 20);
        Product fixedGift = new FixPriceProduct("Подарок");

        ProductBasket basket = new ProductBasket();


        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);


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
    }
}