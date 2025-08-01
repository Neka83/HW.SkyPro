package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    public SimpleProduct(String name, int price) {
        super(name, price);
        // Проверка цены перенесена в суперкласс
    }

    @Override
    public int getPrice() {
        return getBasePrice();
    }
}
