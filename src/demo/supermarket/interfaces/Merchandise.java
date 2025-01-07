package demo.supermarket.interfaces;

public interface Merchandise {

    String getName();

    double getSoldPrice();

    double getPurchasePrice();

    int buy(int count);

    void putBack(int count);

    Category getCategory();

    int getCount();
}
