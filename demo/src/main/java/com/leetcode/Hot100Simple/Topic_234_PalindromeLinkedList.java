package com.leetcode.Hot100Simple;
/**
 * [234] 回文链表
 *  判断是否为回文链表：是指一个单链表从前往后读和从后往前读得到的序列是完全相同的。
 *  输入：head = [1,2,2,1]
    输出：true
 */
public class Topic_234_PalindromeLinkedList {

    private static ListNode frontPointer; // 前向指针（从头部开始移动）
    // 方法二：递归
    // 空间复杂度：O(n)
    private static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode){
        // 递归终止条件：到达链表末尾
        // 返回true是因为空链表null被认为是一个回文链表
        if(currentNode == null) return true;

        // 如果内层递归已经发现不是回文，直接返回false
        if(!recursivelyCheck(currentNode.next)) return false;

        // 值比较
        if(currentNode.val != frontPointer.val) return false;

        // 前向指针移动到下一个节点
        frontPointer = frontPointer.next;
        return true;
    }

    public static void main(String[] args) {
        // 测试用例1: [1,2,2,1] - 是回文
        ListNode head1 = createLinkedList(new int[]{1, 2, 2, 1});
        System.out.println("测试用例1 - 链表: " + listToString(head1));
        
        System.out.println("递归法结果: " + isPalindrome(head1));
        System.out.println();
        
        // 测试用例2: [1,2,3,2,1] - 是回文（奇数长度）
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 2, 1});
        System.out.println("测试用例2 - 链表: " + listToString(head2));
        System.out.println("递归法结果: " + isPalindrome(head2));
        System.out.println();
        
        // 测试用例3: [1,2,3,4] - 不是回文
        ListNode head3 = createLinkedList(new int[]{1, 2, 3, 4});
        System.out.println("测试用例3 - 链表: " + listToString(head3));
        System.out.println("递归法结果: " + isPalindrome(head3));
        System.out.println();
        
        // 测试用例4: [1] - 是回文（单个节点）
        ListNode head4 = createLinkedList(new int[]{1});
        System.out.println("测试用例4 - 链表: " + listToString(head4));
        System.out.println("递归法结果: " + isPalindrome(head4));
        System.out.println();
        
        // 测试用例5: [] - 是回文（空链表）
        ListNode head5 = null;
        System.out.println("测试用例5 - 链表: " + listToString(head5));
        System.out.println("递归法结果: " + isPalindrome(head5));
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
    
    // 将链表转换为字符串的辅助方法
    public static String listToString(ListNode head) {
        if (head == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        
        return sb.toString();
    }
}
