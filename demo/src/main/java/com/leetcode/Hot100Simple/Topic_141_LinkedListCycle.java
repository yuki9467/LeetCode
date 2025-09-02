package com.leetcode.Hot100Simple;

import java.util.HashSet;
import java.util.Set;

/**
 * [141] 环形链表
 *  给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class Topic_141_LinkedListCycle {

    private static boolean hasCycle(ListNode head){
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        
        // 测试用例1: 无环链表 [3,2,0,-4]
        System.out.println("=== 测试用例1: 无环链表 ===");
        ListNode head1 = createLinkedList(new int[]{3, 2, 0, -4});
        System.out.println("链表: " + listToString(head1));
        System.out.println("哈希表法: " + hasCycle(head1));
        System.out.println();
        
        // 测试用例2: 有环链表 [3,2,0,-4]，尾部指向索引1的位置
        System.out.println("=== 测试用例2: 有环链表 ===");
        ListNode head2 = createLinkedList(new int[]{3, 2, 0, -4});
        // 创建环：让最后一个节点(-4)指向第二个节点(2)
        ListNode lastNode2 = getNodeAtIndex(head2, 3); // -4
        ListNode cycleNode2 = getNodeAtIndex(head2, 1); // 2
        lastNode2.next = cycleNode2;
        System.out.println("链表有环，环入口在值: " + cycleNode2.val);
        System.out.println("哈希表法: " + hasCycle(head2));
        System.out.println();
        
        // 测试用例3: 自环链表 [1]
        System.out.println("=== 测试用例3: 自环链表 ===");
        ListNode head3 = new ListNode(1);
        head3.next = head3; // 指向自己形成环
        System.out.println("链表: 1 -> 1 (自环)");
        System.out.println("哈希表法: " + hasCycle(head3));
        System.out.println();
        
        // 测试用例4: 空链表
        System.out.println("=== 测试用例4: 空链表 ===");
        ListNode head4 = null;
        System.out.println("链表: null");
        System.out.println("哈希表法: " + hasCycle(head4));
        System.out.println();
        
        // 测试用例5: 单节点无环链表 [1]
        System.out.println("=== 测试用例5: 单节点无环链表 ===");
        ListNode head5 = new ListNode(1);
        System.out.println("链表: 1 -> null");
        System.out.println("哈希表法: " + hasCycle(head5));
    }
    // 创建链表的辅助方法
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        
        return dummy.next;
    }
    // 将链表转换为字符串的辅助方法（注意：有环链表不能使用这个方法！）
    public static String listToString(ListNode head) {
        if (head == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        Set<ListNode> visited = new HashSet<>();
        
        while (current != null) {
            if (visited.contains(current)) {
                sb.append(" -> (环回到值: ").append(current.val).append(")");
                break;
            }
            visited.add(current);
            sb.append(current.val);
            if (current.next != null && !visited.contains(current.next)) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        
        return sb.toString();
    }
    // 获取链表中第index个节点（从0开始）
    public static ListNode getNodeAtIndex(ListNode head, int index) {
        ListNode current = head;
        int count = 0;
        
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        
        return current;
    }
}
