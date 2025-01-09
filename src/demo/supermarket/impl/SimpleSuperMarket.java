package demo.supermarket.impl;

import demo.supermarket.interfaces.Merchandise;
import demo.supermarket.interfaces.SuperMarket;

public class SimpleSuperMarket implements SuperMarket {

    private String name ="无名";

    private Merchandise[] all;
    private int[] allCount;

    private double totalMoneyEarn;

    private int customerCount;

    public SimpleSuperMarket(Merchandise[] all){
        this.all= all;
        allCount = new int[all.length];
        for(int i=0;


        )
    }
}
