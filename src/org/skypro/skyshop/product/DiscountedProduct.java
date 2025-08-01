package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name, price);
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0% до 100%");
        }
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return getBasePrice() * (100 - discountPercent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}