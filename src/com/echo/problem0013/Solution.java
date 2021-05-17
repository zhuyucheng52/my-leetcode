package com.echo.problem0013;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yucheng
 * @description
 * @create 2021-05-17 下午5:08
 */

public class Solution {
    private static final Map<Character, Integer> romanNumberMap = new HashMap<>();

    static {
        romanNumberMap.put('I', 1);
        romanNumberMap.put('V', 5);
        romanNumberMap.put('X', 10);
        romanNumberMap.put('L', 50);
        romanNumberMap.put('C', 100);
        romanNumberMap.put('D', 500);
        romanNumberMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int preValue = romanNumberMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curValue = romanNumberMap.get(s.charAt(i));
            if (preValue < curValue) {
                result -= preValue;
            } else {
                result += preValue;
            }
            preValue = curValue;
        }
        result += preValue;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt("LVIII");
        System.out.println(result);
    }
}
