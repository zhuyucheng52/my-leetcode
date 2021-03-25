package com.echo.problem011;

import com.echo.utils.ArrUtils;
import sun.jvm.hotspot.utilities.Assert;

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

    public int maxArea1(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int low = Math.min(height[l], height[r]);
            max = Math.max(max, low * (r - l));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        for (int i = 0; i < 10000; ++i) {
            int[] arr = ArrUtils.generateArr(2, 5, 10);
            ArrUtils.print(arr);
            int max1 = maxArea.maxArea1(arr);
            int max2 = maxArea.maxArea2(arr);
            System.out.println("================:" + max2);
            Assert.that(max1 == max2, "计算错误");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
