package com.leetcode.Hot100Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Topic_169_MajorityElement {

    // 2.排序
    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 1.使用哈希表实现
    /* public int majorityElement(int[] nums) {
         // key -> num,value -> count,统计每个元素的数量并放入hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Map.Entry<Integer,Integer> majorEntry = null;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (majorEntry == null || entry.getValue() > majorEntry.getValue()) {
                majorEntry = entry;
            }
        }

        return majorEntry.getKey();

    } */

    // 投票算法
/*     public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
 */

    public static void main(String[] args) {
        
        // 测试用例1：常规情况
        int[] nums1 = {3, 2, 3};
        System.out.println("Test Case 1: " + majorityElement(nums1)); // 预期输出: 3
        
        // 测试用例2：多数元素在数组后半段
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test Case 2: " + majorityElement(nums2)); // 预期输出: 2
        
        // 测试用例3：最小数组（只有一个元素）
        int[] nums3 = {5};
        System.out.println("Test Case 3: " + majorityElement(nums3)); // 预期输出: 5
        
        // 测试用例4：负数元素
        int[] nums4 = {-1, -1, 2, -1, 3, -1, -1};
        System.out.println("Test Case 4: " + majorityElement(nums4)); // 预期输出: -1
    }
}
