package demo.supermarket.impl;

import demo.supermarket.interfaces.Category;
import demo.supermarket.interfaces.Merchandise;

public class SimpleMerchandise implements Merchandise {

    private String name;
    private double soldPrice;
    private double purchasePrice;
    private int count;
    private Category category;

    public SimpleMerchandise(String name, double soldPrice, double purchasePrice, int count, Category category) {
        this.name = name;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        this.count = count;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSoldPrice() {
        return soldPrice;
    }

    @Override
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public int buy(int count) {
        this.count -= count;
        return count;
    }

    @Override
    public void putBack(int count) {
        this.count += count;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
