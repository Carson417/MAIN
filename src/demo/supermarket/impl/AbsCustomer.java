package demo.supermarket.impl;

import demo.supermarket.interfaces.Category;
import demo.supermarket.interfaces.Customer;
import demo.supermarket.interfaces.ShoppingCart;

import static demo.supermarket.util.ShoppingUtil.*;

public abstract class AbsCustomer implements Customer {

    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft;
    private int guangCount;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(String custId, Category shouldBuy, int guangCount) {
        this.shouldBuy = shouldBuy;
        this.custId = custId;
        this.guangCount = guangCount;
    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public AbsCustomer(String custId, Category shouldBuy) {
        this.custId = custId;
        this.shouldBuy = shouldBuy;
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    @Override
    public Category chooseCategory() {
        // 有一次机会看需要买的东西
        if (guangLeft + 1 >= guangCount) {
            return shouldBuy;
        } else {
            return getRandomCategory();
        }
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }

}
