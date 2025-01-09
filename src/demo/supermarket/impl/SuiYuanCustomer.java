package demo.supermarket.impl;

import demo.supermarket.interfaces.Category;
import demo.supermarket.interfaces.Merchandise;

public class SuiYuanCustomer extends AbsCustomer {

    public static final double MUST_BUY_CHANCE = 0.8;
    public static final double GUANG_BUY_CHANCE = 0.1;

    public SuiYuanCustomer(String custId, Category musBuy) {
        super(custId, musBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {
        // 买一个商品的概率
        double chanceToBuy = merchandise.getCategory() == getShouldBuy() ? MUST_BUY_CHANCE : GUANG_BUY_CHANCE;
        // 缘分不到，就返回0
        if (chanceToBuy < Math.random()) {
            return 0;
        } else {
            // 买一个或多个，看缘分到哪
            return 1 + (int) (Math.random() * 3);
        }
    }
}
