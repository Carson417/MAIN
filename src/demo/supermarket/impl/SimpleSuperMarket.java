package demo.supermarket.impl;

import demo.supermarket.interfaces.Category;
import demo.supermarket.interfaces.Merchandise;
import demo.supermarket.interfaces.SuperMarket;

public class SimpleSuperMarket implements SuperMarket {

    private String name = "无名";

    private Merchandise[] all;
    private int[] allCount;

    private double totalMoneyEarn;

    private int customerCount;

    public SimpleSuperMarket(Merchandise[] all) {
        this.all = all;
        allCount = new int[all.length];
        for (int i = 0; i < all.length; i++) {
            allCount[i] = all[i].getCount();
        }
    }

    @Override
    public Merchandise[] getAllMerchandise() {
        return all;
    }

    @Override
    public Merchandise[] getRandoMerchandiseOfCategory(Category category) {
        Merchandise[] ret = new Merchandise[5];
        int pos = 0;
        for (Merchandise m : all) {
            if (m.getCategory() == category && Math.random() > 0.5 && pos < ret.length - 1) {
                ret[pos] = m;
                pos++;
            }
        }
        return ret;
    }

    @Override
    public void addEarnedMoney(double earnedMoney) {
        customerCount++;
        this.totalMoneyEarn += earnedMoney;
    }

    @Override
    public void dailyReport() {
        System.out.println("营业额为：" + totalMoneyEarn);
        System.out.println("商品售出情况如下：");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i].getCategory().name() + "\t"
                    + all[i].getName() + "\t" + (allCount[i] - all[i].getCount()));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
