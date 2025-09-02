package com.leetcode.Hot100Simple;
/**
 * [206] 反转链表
 *  输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]
 */
public class Topic_206_ReverseLinkedList {

    /*  三指针：时间复杂度是O(n),因为每个节点都访问一次，空间复杂度是O(1)
        比如 1->2->3->null 
        * 第一次：1->null, 2->3->null , prev is 1, curr is 2
        * 第二次：2->1->null, 3->null, prev is 2, curr is 3
        * 第三次：3->2->1->null, prev is 3, curr is null
    */
    private static ListNode reverseLinkedList(ListNode head){
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Original linked list:");
        printLinkedList(head);

        ListNode newHead = reverseLinkedList(head);
        System.out.println("Reversed linked list (Iterative):");
        printLinkedList(newHead);

    }

    /**
     * 辅助方法：打印链表
     * @param head 链表的头节点
     */
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> NULL");
    }
}
