package com.echo.problem0005;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3414 👎 0


import com.echo.utils.ArrUtils;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            int oddMax = maxPalindromeOdd(s, i);
            if (oddMax > max) {
                max = oddMax;
                startIndex = i - (max - 1) / 2;
            }

            int noddMax = maxPalindromeNOdd(s, i);
            if (noddMax > max) {
                max = noddMax;
                startIndex = i - max / 2;
            }
        }
        return s.substring(startIndex, startIndex + max);
    }

    public int maxPalindromeNOdd(String s, int index) {
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (!(s.charAt(left) == s.charAt(right))) {
                break;
            }
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public int maxPalindromeOdd(String s, int index) {
        int left = index;
        int right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (!(s.charAt(left) == s.charAt(right))) {
                break;
            }
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10000; ++i) {
            String str = ArrUtils.generateStr(10, 11);
            System.out.println(str);
//        String str = "ac";
            String result = s.longestPalindrome(str);
            System.out.println("===================" + result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
