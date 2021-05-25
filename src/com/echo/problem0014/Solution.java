package com.echo.problem0014;

/**
 * @author yucheng
 * @description
 * @create 2021-05-17 下午6:13
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return null;
        } else if (strs.length == 1) {
            return strs[0];
        }

        String str0 = strs[0];
        int i = 0;
        while (i < str0.length()) {
            Character c0 = str0.charAt(i);
            System.out.println(c0 + "\t" + i);
            for (int j = 1; j < strs.length; ++j) {
                String str = strs[j];
                if (str.length() <= i
                        || str.charAt(i) != c0) {
                    return str0.substring(0, i);
                }
            }
            ++i;
            System.out.println();
        }
        return str0.substring(0, i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = solution.longestCommonPrefix(new String[]{"abcdaa", "abcdaa", "abcdaa"});
        System.out.println(str);
    }
}
