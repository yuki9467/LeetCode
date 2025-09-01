package com.leetcode.Hot100Simple;

/**
 * [283] 移动零
 *  将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *  输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
 */
public class Topic_283_MoveZeroes {

    // 双指针：时间复杂度为 O(N)，空间复杂度为 O(1)
    private static void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0)return;

        // 记录下一个非0元素应该放置的位置（也即已经处理好的非零序列的下一个位置）
        int slow = 0;

        // 第一次遍历将所有非0x
        // fast指针遍历整个数组，寻找非0元素
        for(int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 第二次遍历将slow之后的所有位置填充为0
        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }

    }

    // 辅助方法：打印数组
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 测试方法
    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.print("原始数组1: ");
        printArray(nums1);
        moveZeroes(nums1);
        System.out.print("移动后: ");
        printArray(nums1);
        
        // 测试用例2
        int[] nums2 = {0};
        System.out.print("\n原始数组2: ");
        printArray(nums2);
        moveZeroes(nums2);
        System.out.print("移动后: ");
        printArray(nums2);
        
        // 测试用例3
        int[] nums3 = {1, 2, 3};
        System.out.print("\n原始数组3: ");
        printArray(nums3);
        moveZeroes(nums3);
        System.out.print("移动后: ");
        printArray(nums3);
        
        // 测试用例4
        int[] nums4 = {0, 0, 0, 1, 2};
        System.out.print("\n原始数组4: ");
        printArray(nums4);
        moveZeroes(nums4);
        System.out.print("移动后: ");
        printArray(nums4);
    }

        
}
