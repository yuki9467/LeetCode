package com.leetcode.Hot100Simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1] 两数之和
 *  输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Topic_1_TwoSum {

    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] arrays = twoSum(nums, 6);
        System.out.println(Arrays.toString(arrays));

        int[] nums2 = {2,7,11,15};
        int[] arrays2 = twoSum(nums2, 9);
        System.out.println(Arrays.toString(arrays2));
    }
}
