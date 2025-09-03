package com.leetcode.Hot100Simple;
/**
 * [21] 合并两个有序链表
 *  输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
 */
public class Topic_21_MergeTwoSortedLists {

    /**
     * 迭代法
     * 时间复杂度：O(n+m)，空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
         // 创建哨兵节点简化边界处理
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        // 遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        // 连接剩余部分
        curr.next = (l1 != null)? l1: l2;
        
        return dummy.next;
    }

    // 测试方法
    public static void main(String[] args) {
        
        // 测试用例1
        ListNode l1 = createList(new int[]{1, 2, 4});
        ListNode l2 = createList(new int[]{1, 3, 4});
        ListNode merged = mergeTwoLists(l1, l2);
        System.out.print("测试用例1: ");
        printList(merged);  // 预期: 1->1->2->3->4->4
        
        // 测试用例2：空链表
        ListNode l3 = createList(new int[]{});
        ListNode l4 = createList(new int[]{0});
        System.out.print("测试用例2: ");
        printList(mergeTwoLists(l3, l4));  // 预期: 0
        
        // 测试用例3：递减链表
        ListNode l5 = createList(new int[]{5, 4, 3});
        ListNode l6 = createList(new int[]{6, 2, 1});
        System.out.print("测试用例3: ");
        printList(mergeTwoLists(l5, l6));  // 预期: 5->4->3->6->2->1
    }

    /**
     * 创建链表（用于测试）
     * @param values 链表值数组
     * @return 链表头节点
     */
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 打印链表（用于测试）
     * @param head 链表头节点
     */
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

}
