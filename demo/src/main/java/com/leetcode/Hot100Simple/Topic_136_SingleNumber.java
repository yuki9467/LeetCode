package com.leetcode.Hot100Simple;
/**
 * [136] 只出现一次的数字
 *  除了某个元素只出现一次以外，其余每个元素均出现两次。
 *  输入：nums = [4,1,2,1,2]
    输出：4
 */
public class Topic_136_SingleNumber {

    /**
     * 位运算（异或操作）
     *  任何数和 0 做异或运算，结果仍然是原来的数：a ^ 0 = a
        任何数和其自身做异或运算，结果是 0：a ^ a = 0
        异或运算满足交换律和结合律：a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums){

        int result = 0;

        for(int num : nums){
            result ^= num;
        }
        return result;
    }

    // Main 方法用于测试
    public static void main(String[] args) {
        
        // 测试用例1
        int[] nums1 = {2, 2, 1};
        System.out.println("数组 [2, 2, 1] 中只出现一次的数字是: " + singleNumber(nums1)); // 输出 1
        
        // 测试用例2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("数组 [4, 1, 2, 1, 2] 中只出现一次的数字是: " + singleNumber(nums2)); // 输出 4
        
        // 测试用例3
        int[] nums3 = {1};
        System.out.println("数组 [1] 中只出现一次的数字是: " + singleNumber(nums3)); // 输出 1
        
        // 测试用例4
        int[] nums4 = {7, 3, 5, 3, 7};
        System.out.println("数组 [7, 3, 5, 3, 7] 中只出现一次的数字是: " + singleNumber(nums4)); // 输出 5
    }
}
