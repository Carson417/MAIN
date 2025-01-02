package ds_al.basic_ds.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单链表
 * 1.在链表头添加
 * 2.在链表尾添加（找最后一个节点）
 * 3.遍历：（1）for (2)while (3)迭代器
 * 4.根据索引找节点
 * 5.向索引位置插节点
 * 6.删除节点：1）删除第一个节点 2）按索引删除节点
 */
public class SingleLinkedList implements Iterable<Integer> {

    // 头指针
    private Node head;

    // 当内部类不需要访问外部类的实例成员时，可以将其声明为 static
    private static class Node {
        int value;
        Node next;

        // 定义内部类好处：实现隐藏细节
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 链表头添加元素
     */
    public void addFirst(int value) {
        // case1:链表为空
        // 为什么是head而不是head.next,因为此时head是null，会空指针
        // 是head指向这个第一个元素，引用，其实就是一个，而不是顺序的下一个元素,把head当引用而不是指针
        // head = new Node(value, null);

        // case2:链表中非空
        // 可以处理上种情况
        head = new Node(value, head);
    }

    /**
     * 在链表尾添加元素
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    // 找最后一个节点
    private Node findLast() {
        Node p = head;
        if (p == null) {    // 不判断会有空指针
            return p;
        }
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 遍历链表方法1：for
     */
    public void loop_for(Consumer<Integer> consumer) {
        for (Node node = head; node != null; node = node.next) {
            consumer.accept(node.value);
        }
    }

    /**
     * 遍历链表方法2：while
     */
    public void loop_while(Consumer<Integer> consumer) {
        Node node = head;
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
            Node node = head;

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
        int i = 0;
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
        if (index == 0) {
            addFirst(value);
            return;
        }
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
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    /**
     * 按索引删除节点
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
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






























