package ds_al.basic_ds.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 带哨兵的单链表（头节点）
 * 有些判空可以不需要了
 * 注意遍历跟索引相关的不是从head，而是head.next
 * 哨兵索引当-1
 */
public class SingleLinkedListSentinel implements Iterable<Integer> {

    // 头指针指向哨兵（头节点）
    private final Node head = new Node(0, null);

    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 链表头添加元素
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * 在链表尾添加元素
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    // 找最后一个节点
    private Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 遍历链表方法1：for
     */
    public void loop_for(Consumer<Integer> consumer) {
        for (Node node = head.next; node != null; node = node.next) {
            consumer.accept(node.value);
        }
    }

    /**
     * 遍历链表方法2：while
     */
    public void loop_while(Consumer<Integer> consumer) {
        Node node = head.next;
        while (node != null) {
            consumer.accept(node.value);
            node = node.next;
        }
    }

    /**
     * 遍历链表方法3:迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类，为什么不加static，因为需要外部类的成员变量
        return new Iterator<Integer>() {
            Node node = head.next;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Integer next() {
                int value = node.value;
                node = node.next;
                return value;
            }
        };
    }


    /**
     * 根据给定索引位置找节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        // 没有找到
        return null;
    }

    /**
     * 根据给定索引位置找节点的值
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            // 抛异常，非法参数
            throw illegalIndex(index);
        }
        return node.value;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法", index));
    }

    /**
     * 向索引位置插节点
     */
    public void insert(int index, int value) {
        // 找到上一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }


    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 按索引删除节点
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;

    }
}
