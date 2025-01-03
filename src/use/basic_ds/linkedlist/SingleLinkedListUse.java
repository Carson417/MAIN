package use.basic_ds.linkedlist;


import ds_al.basic_ds.linkedlist.SingleLinkedList;

public class SingleLinkedListUse {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        // 索引为2的值为3，非法索引抛异常
        System.out.println(list.get(2));
        // 这个consumer是你拿到的值，对这个值有什么处理
        list.loop_while((value)->{
            System.out.println(value);
        });
        for (Integer i : list) {
            System.out.println(i);
        }


        list.loop_recursion(value->{
            System.out.println(value);
        },value->{
            System.out.println(value);
        });
    }
}
