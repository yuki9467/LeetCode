package com.leetcode.Hot100Simple;

import java.util.HashSet;
import java.util.Set;

/**
 * [160] 相交链表
 *  输入 listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 *  输出 Intersected at '8'
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
public class Topic_160_IntersectionOfTwoLinkedLists {

    // 方法一：双指针
    /* private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            // 如果 curA 到达链表末尾，重定位到 headB
            curA = (curA == null) ? headB : curA.next;
            // 如果 curB 到达链表末尾，重定位到 headA
            curB = (curB == null) ? headA : curB.next;
        }
        
        // 返回交点（或 null）
        return curA;

    } */

    // 方法二：放到hashset里
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;
        
        Set<ListNode> visited = new HashSet<>();

        ListNode temp = headA;

        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        // ====== 构建测试链表 ======
        // 公共部分（相交节点）
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);
        
        // 链表 A：4->1->公共部分
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;
        
        // 链表 B：5->0->1->公共部分
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // ====== 执行测试用例 ======
        // 测试1：正常相交情况
        ListNode result1 = getIntersectionNode(headA, headB);
        System.out.println("测试1 - 相交节点值: " + result1.val); // 应输出8
        
        // 测试2：不相交情况
        ListNode headC = new ListNode(2);
        headC.next = new ListNode(6);
        headC.next.next = new ListNode(4);
        
        ListNode result2 = getIntersectionNode(headA, headC);
        System.out.println("测试2 - 不相交结果: " + result2); // 应输出null
        
        // 测试3：一个链表为空
        ListNode result3 = getIntersectionNode(headA, null);
        System.out.println("测试3 - 空链表结果: " + result3); // 应输出null
        
        // 测试4：相同头节点
        ListNode result4 = getIntersectionNode(headA, headA);
        System.out.println("测试4 - 相同头节点: " + result4.val); // 应输出4
        
        // 测试5：不同长度链表
        ListNode headD = new ListNode(5);
        headD.next = common; // 直接指向公共部分
        ListNode result5 = getIntersectionNode(headA, headD);
        System.out.println("测试5 - 不同长度链表相交: " + result5.val); // 应输出8
   
    }
}
