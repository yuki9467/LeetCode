package com.interview;
/**
 * Input: strs = ["flower","flow","flowght","flowopq"]
 * outout: flow
 */
public class FindCommonStr {
    /**
     * 水平扫描法
     * @param strs
     * @return
     */
    public static String findCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        // 以第一个字符串为基准
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // 不断缩短前缀，直到找到当前字符串的公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }


    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flowght", "flowopq"};
        String result = findCommonPrefix(input);
        System.out.println("output strs=" + result); // 输出: flow
    }

    /**
     * 二分查找法：对可能的前缀长度进行二分查找
     * 时间复杂度：O(S·log m)，其中m是最短字符串的长度
     * @param strs
     * @return
     * Input: strs = ["flower","flow","flowght","flowopq"]
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // 找到最短字符串的长度
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        
        int low = 1;
        int high = minLen;
        
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        
        return strs[0].substring(0, (low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
