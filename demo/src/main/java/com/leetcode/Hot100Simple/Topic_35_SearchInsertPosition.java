package com.leetcode.Hot100Simple;
/**
 * [35] 搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Topic_35_SearchInsertPosition {

    /**
     * 二分查找法
     */
    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果未找到，插入位置是 left
        return left;
    }

    // Main 方法用于测试
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        int target4 = 0;

        System.out.println("Target 5 found or should be inserted at index: " + searchInsert(nums, target1)); // 输出 2
        System.out.println("Target 2 found or should be inserted at index: " + searchInsert(nums, target2)); // 输出 1
        System.out.println("Target 7 found or should be inserted at index: " + searchInsert(nums, target3)); // 输出 4
        System.out.println("Target 0 found or should be inserted at index: " + searchInsert(nums, target4)); // 输出 0
    }
}
