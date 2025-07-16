package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

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

        // Добавляем 5 продуктов
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);

        // Пробуем добавить 6-й продукт
        basket.addProduct(extra);

        // Печать корзины
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