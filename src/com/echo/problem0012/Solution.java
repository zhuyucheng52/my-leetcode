package com.echo.problem0012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yucheng
 * @description
 * @create 2021-05-15 下午7:32
 */

public class Solution {
    private static final Map<Integer, String> numbeRomanMap = new HashMap<>();
    private static final List<Integer> orderedNums = new ArrayList<>();

    static {
        numbeRomanMap.put(1, "I");
        numbeRomanMap.put(4, "IV");
        numbeRomanMap.put(5, "V");
        numbeRomanMap.put(9, "IX");
        numbeRomanMap.put(10, "X");
        numbeRomanMap.put(40, "XL");
        numbeRomanMap.put(50, "L");
        numbeRomanMap.put(90, "XC");
        numbeRomanMap.put(100, "C");
        numbeRomanMap.put(400, "CD");
        numbeRomanMap.put(500, "D");
        numbeRomanMap.put(900, "CM");
        numbeRomanMap.put(1000, "M");

        orderedNums.addAll(numbeRomanMap.keySet());
        orderedNums.sort((i1, i2) -> Integer.compare(i2, i1));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            int item = orderedNums.get(i);
            if (item <= num) {
                num -= item;
                sb.append(numbeRomanMap.get(item));
                continue;
            } else {
                ++i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = solution.intToRoman(1994);
        System.out.println(str);
    }
}

