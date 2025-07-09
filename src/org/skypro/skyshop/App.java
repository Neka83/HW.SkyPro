package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 120);
        Product milk = new Product("Молоко", 80);
        Product bread = new Product("Хлеб", 50);
        Product cheese = new Product("Сыр", 200);
        Product extra = new Product("Доп. товар", 150);

        ProductBasket basket = new ProductBasket();

        // Добавляем 5 продуктов
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);

        // Пробуем добавить 6-й продукт
        basket.addProduct(extra);

        // Печать корзины (basket)
        basket.printBasket();

        // Общая стоимость
        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        // Поиск товаров
        System.out.println("Есть ли 'Хлеб'? " + basket.containsProduct("Хлеб"));
        System.out.println("Есть ли 'Масло'? " + basket.containsProduct("Масло"));

        // Очистка корзины
        basket.clearBasket();

        // Печать пустой корзины
        basket.printBasket();

        // Проверки в пустой корзине
        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        System.out.println("Есть ли 'Яблоко'? " + basket.containsProduct("Яблоко"));
    }
}