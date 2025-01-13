package demo.supermarket.impl;

import demo.supermarket.interfaces.Card;
import demo.supermarket.interfaces.Category;
import demo.supermarket.interfaces.HasCard;
import demo.supermarket.interfaces.Merchandise;

public class ThinkAndBuyCustomer extends AbsCustomer implements HasCard {

    private Card card = VIPCard.Level0;

    public ThinkAndBuyCustomer(String custId, Category shouldBy) {
        super(custId, shouldBy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {

        Category category = merchandise.getCategory();
        // 需要买的就买一个
        if (category == getShouldBuy()) {
            return 1;
        }

        double soldPrice = merchandise.getSoldPrice();

        double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;
        if (soldPrice < avgPrice) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return card;
    }
}
