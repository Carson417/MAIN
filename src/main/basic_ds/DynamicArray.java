package main.basic_ds;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 * 1.添加元素
 * 2.扩容
 * 3.遍历元素：函数式接口、迭代器、流
 * 4.删除元素
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0;            //逻辑大小
    private int capacity = 8;       //容量
    private int[] array = {};

    /**
     * 添加元素
     */
    public void add(int index, int element) {
        checkAndEnlarge();
        // 添加元素
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 容量检查，是否需要扩容
     */
    private void checkAndEnlarge() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            // 判断是否扩容，java一般扩容1.5倍
            capacity += capacity >> 1;
            int[] enlarge = new int[capacity];
            System.arraycopy(array, 0, enlarge, 0, size);
            array = enlarge;
        }
    }

    /**
     * 遍历方法1：通过函数式接口；
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // 提供array[i]，返回void
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历方法2：通过迭代器，需要实现接口
     */
    @Override
    // 返回的是Iterator类型的对象
    public Iterator<Integer> iterator() {
        // 匿名内部类，先写一个实现类，返回new这个实现类的对象
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            // 是否有下一个元素
            public boolean hasNext() {
                return i < size;
            }

            @Override
            // 返回到当前元素，并移动到下一个元素
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3：通过流
     */
    public IntStream foreachByStream() {
        // 如果直接把array传进去，那范围就是到capacity了
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    /**
     * 删除元素
     */
    public int remove(int index) {
        int removed = array[index];
        // 删除最后一个元素就不需要再copy了
        if (index < size - index - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
