package use.basic_ds;


import ds_al.basic_ds.DynamicArray;

public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        /**
         * 使用add
         */
        dynamicArray.add(0, 0);

        /**
         * 使用foreach
         */
        dynamicArray.foreach((element) -> {
            // 打印每个元素
            System.out.println(element);
        });

        /**
         * 使用迭代器遍历
         */
        // 会调用hasNext()和next()
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }

        /**
         * 删除
         */
        dynamicArray.remove(0);
    }

}
