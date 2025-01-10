package ds_al.basic_ds.linkedlist.operation;

import ds_al.basic_ds.linkedlist.common.ListNode;

/**
 * 反转链表，力扣206
 * <p>
 * 方1：构造新链表，从旧节点依次拿每个节点，创建新节点并填在头部
 */
public class ReverseSingleLinkedList {

    /**
     * 方1：构造新链表，从旧节点依次拿每个节点，创建新节点并填在头部
     */
    public ListNode reverse1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }


    public static void main(String[] args) {

        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new ReverseSingleLinkedList().reverse1(o1);
        System.out.println(n1);
    }
}
