package com.echo.problem0004;

import com.echo.utils.ArrUtils;

import java.util.Arrays;

/**
 * @author yucheng
 * @description
 * @create 2021-05-21 下午4:55
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = mergeArr(nums1, nums2);
        return findMedian(arr);
    }

    private double findMedian(int[] arr) {
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            int left = (arr.length - 1) / 2;
            int right = arr.length / 2;
            return (arr[right] + arr[left]) / 2.0;
        }
    }

    private int[] mergeArr(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = ArrUtils.generateIntArr(3, 10);
        Arrays.sort(nums1);
        ArrUtils.print(nums1);
        int[] nums2 = ArrUtils.generateIntArr(5, 10);
        Arrays.sort(nums2);
        ArrUtils.print(nums2);
        double mid = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }
}
