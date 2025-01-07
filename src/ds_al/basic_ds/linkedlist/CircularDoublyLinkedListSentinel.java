package ds_al.basic_ds.linkedlist;

import java.util.Iterator;

/**
 * 双向环形链表
 * 带哨兵,既是头节点又是尾节点
 * <p>
 * 1.添加到第一个、最后一个
 * 2.删除第一个、最后一个
 * 3.根据值删除
 */
public class CircularDoublyLinkedListSentinel implements Iterable<Integer> {

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, 0, null);

    public CircularDoublyLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法", index));
    }

    /**
     * 添加到第一个
     */
    public void addFirst(int value) {
        Node added = new Node(sentinel, value, sentinel.next);
        sentinel.next = added;
        sentinel.next.prev = added;
    }

    /**
     * 添加到最后一个
     */
    public void addLast(int value) {
        Node added = new Node(sentinel.prev, value, sentinel);
        sentinel.prev.next = added;
        sentinel.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        // 如果只有哨兵，不能删
        if (sentinel.next == sentinel) {
            throw new IllegalArgumentException();
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        // 如果只有哨兵，不能删
        if (sentinel.next == sentinel) {
            throw new IllegalArgumentException();
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
    }

    /**
     * 根据值删除
     * 从哨兵的下一个节点开始找
     */
    public void removeByValue(int value) {
        Node node = findNode(value);
        if (node == null) {
            return;   //不用删
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 根据值找节点
     */
    private Node findNode(int value) {
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (p.value == value) {
                return p;
            }
        }
        return null;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // 哨兵无需遍历
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
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
