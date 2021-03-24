package com.echo.problem11;

import java.rmi.server.RMIClassLoader;
import java.util.logging.Level;

/**
 * @author yucheng
 * @description
 * @create 2021-03-17 上午10:40
 */

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2273 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class MaxArea {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int lMax = height[0];
        int rMax = height[height.length - 1];
        int l = 1;
        int r = height.length - 2;
        int max = 0;
        while (l <= r) {
            if (lMax <= rMax) {
                lMax = Math.max(lMax, height[l]);
                System.out.println("index: " + l);
                max += Math.max(0, lMax - height[l++]);
            } else {
                rMax = Math.max(rMax, height[r]);
                System.out.println("index: " + r);
                max += Math.max(0, rMax - height[r--]);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int lMax = height[0];
        int rMax = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                lMax = Math.max(lMax, height[l]);
                max += lMax;
                System.out.println("index: " + l + "-" + lMax);
                ++l;
            } else {
                rMax = Math.max(rMax, height[r]);
                max += rMax;
                System.out.println("index: " + r + "-" + rMax);
                --r;
            }
        }

        return max;
    }

    public int maxArea3(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int low = Math.min(height[l], height[r]);
            max = Math.max(max, low * (r - l));
            if (height[l] < height[r]) {

            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int max = maxArea.maxArea3(new int[]{1, 1});
        System.out.println(max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
