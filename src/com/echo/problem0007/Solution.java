package com.echo.problem0007;

/**
 * @author yucheng
 * @description
 * @create 2021-03-27 下午12:38
 */

public class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int res = x % 10;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && res > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10
                    || (ans == Integer.MIN_VALUE / 10 && res < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            ans = ans * 10 + res;
            x /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.reverse(154236469);
        System.out.println(ans);
    }
}
