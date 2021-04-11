package com.echo.problem0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yucheng
 * @description
 * @create 2021-04-10 下午8:55
 */

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int firstIndex = 0;
        int count = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++count;
            } else {
                if (count >= 2) {
                    ans.add(Arrays.asList(firstIndex, i - 1));
                }
                count = 0;
                firstIndex = i;
            }
        }
        if (count >= 2) {
            ans.add(Arrays.asList(firstIndex, s.length() - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.largeGroupPositions("abcdddeeeeaabbbcd");
        System.out.println(ans);
    }

}
