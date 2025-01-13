package demo.supermarket.interfaces;

/**
 * 超市的折扣策略
 */
public interface DiscountStrategy {

    /**
     * @param shoppingCart 购物车
     * @return 因为此折扣策略所扣掉的钱，注意并非折扣的总价
     */
    double discount(ShoppingCart shoppingCart);
}
