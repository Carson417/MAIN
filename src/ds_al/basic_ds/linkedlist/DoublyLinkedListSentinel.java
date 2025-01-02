package ds_al.basic_ds.linkedlist;

import java.util.Iterator;

/**
 * 带哨兵的双向链表（头哨兵、尾哨兵）
 * 没有头指针，头哨兵索引为-1
 * 和单链表比优势就在操作最后一个节点
 * <p>
 * 1.根据索引找节点
 * 2.插入
 * 3.删除
 */

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node {
        Node prev;
        int value;
        Node next;

        Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, 0, null);
        tail = new Node(null, 0, null);
        head.next = tail;
        tail.prev = head;

        // 也可以写成这个，Java 允许在构造函数中传递未初始化的引用
        // head = new Node(null, 0, tail);
        // tail = new Node(head, 0, null);
    }

    /**
     * 根据索引找节点
     */
    private Node findNode(int index) {
        int i = -1;
        // 终止为指向tail
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法", index));
    }

    /**
     * 按索引插入
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;

        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * 在最后添加
     */
    public void addLast(int value) {
        Node inserted = new Node(tail.prev, value, tail);
        tail.prev.next = inserted;
        tail.prev = inserted;
    }

    /**
     * 按索引删除
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        // 待删除的是尾节点
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    /**
     * 在最后删除
     */
    public void removeLast() {
        Node removed = tail.prev;
        // 如果要删的是头哨兵
        if (removed == head) {
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // 注意头哨兵的下一个元素是第一个元素
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
















































