package com.echo.problem0015;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3164 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        for (int  i = 0; i < nums.length - 2; ++i) {
            if (i != 0 &&
                nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;

            do {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    res.add(item);

                    do {
                        ++start;
                    } while (start < end && nums[start - 1] == nums[start]);

                    do {
                        --end;
                    } while (start < end && nums[end + 1] == nums[end]);
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    do {
                        --end;
                    } while (start < end && nums[end + 1] == nums[end]);
                } else {
                    do {
                        ++start;
                    } while (start < end && nums[start - 1] == nums[start]);
                }
            } while (start < end);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0, 0};
        List<List<Integer>> res = s.threeSum(nums);
        for (List<Integer> item : res) {
            System.out.println(item);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
