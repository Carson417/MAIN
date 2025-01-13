package demo.supermarket.impl;

import demo.supermarket.interfaces.Card;
import demo.supermarket.interfaces.Customer;
import demo.supermarket.interfaces.ShoppingCart;

public enum VIPCard implements Card {

    Level0(1),
    Level1(0.99),
    Level2(0.95),
    Level3(0.9),
    Level4(0.85),
    Level5(0.8);


    private double discount;

    VIPCard(double discount) {
        this.discount = discount;
    }

    /**
     * 返回的是省的多少钱
     */
    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount, Customer customer, ShoppingCart shoppingCart) {
        return totalCostAfterDiscount * (1 - discount);
    }
}
