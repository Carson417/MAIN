package demo.supermarket.interfaces;

public interface SuperMarket {

    /**
     * 获取所有商品
     */
    Merchandise[] getAllMerchandise();

    /**
     * 根据分类随机选择商品
     */
    Merchandise[] getRandoMerchandiseOfCategory(Category category);

    void addEarnedMoney(double earnedMoney);

    void dailyReport();
}
