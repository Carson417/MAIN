package demo.supermarket.util;

import demo.supermarket.interfaces.Category;

public class ShoppingUtil {

    public static Category getRandomCategory() {
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

//    public static VIPCard getRandomVIPCard() {
//        return VIPCard.values()[(int) (Math.random() * 1000) % VIPCard.values().length];
//    }
}
