package com.echo.problem0154;

/**
 * @author yucheng
 * @description
 * @create 2021-04-10 上午9:48
 */

public class Solution {
    public int findMin(int[] nums) {
        return doFindMin2(nums, 0, nums.length - 1);
    }

    private int doFindMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 1;
        while (i < nums.length) {
            if (nums[i - 1] > nums[i]) {
                break;
            }
            ++i;
        }

        if (i == nums.length) {
            return nums[0];
        } else {
            return nums[i];
        }
    }

    private int doFindMin2(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (right + left) / 2;
        if (nums[mid] < nums[right]) {
            return doFindMin2(nums, left, mid);
        } else if (nums[mid] == nums[right]) {
            return doFindMin2(nums, left, right - 1);
        } else {
            return doFindMin2(nums, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 3, 1, 3};
        int ans = s.findMin(nums);
        System.out.println(ans);
    }
}
