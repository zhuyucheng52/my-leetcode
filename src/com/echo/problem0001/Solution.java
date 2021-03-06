package com.echo.problem0001;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10591 👎 0


import com.echo.utils.ArrUtils;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            if (container.containsKey(tmp)) {
                return new int[]{container.get(tmp), i};
            } else {
                container.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int minLength = 2;
        int maxLength = 4;
        int target = 10;
        for (int i = 0; i < 10000; ++i) {
            int[] nums = ArrUtils.generateIntArr(minLength, maxLength, 10);
            ArrUtils.print(nums);
            int[] indexs1 = s.twoSum1(nums, target);
            ArrUtils.print(indexs1);
            int[] indexs2 = s.twoSum2(nums, target);
            ArrUtils.print(indexs2);
            boolean equals = ArrUtils.arrEquals(indexs1, indexs2);
            System.out.println("====================:" + equals);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
