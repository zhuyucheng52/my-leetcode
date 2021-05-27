package com.echo.problem0008;

/**
 * @author yucheng
 * @description
 * @create 2021-05-25 下午4:47
 */

public class Solution {
    public static class Tuple {
        String prefix = "";
        int leftIndex = 0;
    }

    public int myAtoi(String s) {
        String numStr = splitNum(s);
        if (numStr != null) {
            return parseint(numStr);
        } else {
            return 0;
        }
    }

    private int parseint(String str) {
        int tmp = 0;
        if (str.startsWith("-")) {
            for (int i = 1; i < str.length(); ++i) {
                if ((tmp * 10) / 10 != tmp) {
                    return Integer.MIN_VALUE;
                }
                tmp *= 10;
                int n = str.charAt(i) - '0';
                if (tmp - n > tmp) {
                    return Integer.MIN_VALUE;
                }
                tmp -= n;
            }
            return tmp;
        } else {
            for (int i = 0; i < str.length(); ++i) {
                if ((tmp * 10) / 10 != tmp) {
                    return Integer.MAX_VALUE;
                }
                tmp *= 10;

                int n = str.charAt(i) - '0';
                if (tmp + n < tmp) {
                    return Integer.MAX_VALUE;
                }
                tmp += n;
            }
            return tmp;
        }
    }

    private String splitNum(String s) {
        Tuple t = splitLeft(s);

        if (t != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = t.leftIndex; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                } else {
                    break;
                }
            }
            String str = processPrefix(t.prefix);
            return str + sb.toString();
        } else {
            return null;
        }
    }

    private String processPrefix(String prefix) {
        int minusCount = 0;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (c == '-') {
                ++minusCount;
            }
        }

        return minusCount % 2 == 0 ? "" : "-";
    }

    private Tuple splitLeft(String s) {
        Tuple t = new Tuple();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (i < (s.length() - 1)) {
                    char c2 = s.charAt(i + 1);
                    if (c2 == '-' || c2 == '+') {
                        return null;
                    } else if (!Character.isDigit(c2)) {
                        return null;
                    }
                }
                t.prefix += c;
            } else if (c >= '0' && c <= '9') {
                t.leftIndex = i;
                return t;
            } else if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
            } else {
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.myAtoi("  +  413");
        System.out.println(res);
    }
}
