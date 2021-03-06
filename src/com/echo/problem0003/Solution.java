package com.echo.problem0003;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5193 👎 0


import com.echo.utils.ArrUtils;
import sun.jvm.hotspot.utilities.Assert;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int lengthOfLongestSubstring1(String s) {
       Set<Character> set = new HashSet<>();
       int j = 0;
       int max = 0;
       for (int i = 0; i < s.length(); ++i) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove((s.charAt(j++)));
                }
                set.add(s.charAt(i));
            }
       }

       return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int j = i;
        int max = 0;
        while (i++ < s.length()) {
            Set<Character> set = new HashSet<>();
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
            j = i;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10000; ++i) {
            String str = ArrUtils.generateStr(5, 10);
            int max1 = s.lengthOfLongestSubstring1(str);
            int max2 = s.lengthOfLongestSubstring2(str);
//            System.out.println(str + "\t" + max1);
            Assert.that(max1 == max2, "计算错误");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
