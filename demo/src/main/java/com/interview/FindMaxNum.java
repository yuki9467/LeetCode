package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 输出最大数字，按照如下输入输出例子：
 * 1.a1b2c3d4 ---> 4

 2.a11b2c3d4 ---> 11

 3.123 ---> 123

 4.abc ---> null

 5.-999abc888 ---> 999
 */
public class FindMaxNum {
    // 非正则方式
    private static String getMaxNum(String input){

        if (input == null || input.isEmpty()) {
            return null;
        }

        int maxNumber = Integer.MIN_VALUE;
        int currentNumber = 0;
        boolean isNegative = false;
        boolean hasNumber = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '-' && i < input.length() - 1 && Character.isDigit(input.charAt(i + 1))) {
                isNegative = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
                int digit = c - '0';
                currentNumber = currentNumber * 10 + digit;
                
                // 检查是否到达字符串末尾或下一个字符不是数字
                if (i == input.length() - 1 || !Character.isDigit(input.charAt(i + 1))) {
                    if (isNegative) {
                        currentNumber = -currentNumber;
                        isNegative = false;
                    }
                    
                    if (Math.abs(currentNumber) > Math.abs(maxNumber)) {
                        maxNumber = currentNumber;
                    }
                    currentNumber = 0;
                }
            } else {
                // 遇到非数字字符，重置负数标志
                isNegative = false;
            }
        }

        if (!hasNumber) {
            return null;
        }

        return String.valueOf(Math.abs(maxNumber));

    }

    //正则
    /**
     * 这个正则表达式用于匹配整数（包括正数和负数），让我们分解它的每个部分：-?\\d+

        表达式分解
        -?
            - 匹配减号/负号字符本身
            ? 量词，表示前面的元素（这里是-）出现0次或1次
            组合起来 -? 表示："可能有负号，也可能没有"
        \\d
            \d 是预定义字符类，匹配任意数字字符（等价于 [0-9]）
            在Java字符串中，反斜杠需要转义，所以写作 \\d
        +
            量词，表示前面的元素（这里是\\d）出现1次或多次
            确保至少有一个数字

        -?\\d+ 整体表示：

            可选的一个负号（-），后面跟着
            一个或多个数字（0-9）
     * 
     */
    private static String findMaxNumber(String input) {
        // 使用正则表达式匹配所有整数（包括负数）
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        
        List<Integer> numbers = new ArrayList<>();
        
        while (matcher.find()) {
            String numStr = matcher.group();
            // 转换为整数并添加到列表中
            numbers.add(Integer.parseInt(numStr));
        }
        
        if (numbers.isEmpty()) {
            return null;
        }
        
        // 找到最大的数字（绝对值最大的）
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            int absNum = Math.abs(num);
            if (absNum > Math.abs(max)) {
                max = num;
            }
        }
        
        // 返回最大的数字（以字符串形式）
        return String.valueOf(max);
    }

    public static void main(String[] args) {
        // 测试用例
        String[] testCases = {
            "a1b2c3d4",    // 4
            "a11b2c3d4",   // 11
            "123",         // 123
            "abc",        // null
            "-999abc888"  // 999
        };
        
        for (String testCase : testCases) {
            // String result = getMaxNum(testCase);
            String result = findMaxNumber(testCase);
            System.out.println(testCase + " ---> " + (result != null ? result : "null"));
        }
    }
}
