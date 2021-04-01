package com.echo.sort;

import com.echo.utils.ArrUtils;

/**
 * @author yucheng
 * @description
 * @create 2021-03-30 下午6:39
 */

public class BubbleSort {
    public int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = arr.length - 1; j > i; --j) {
                if (arr[j] < arr[j - 1]) {
                    ArrUtils.swap(arr, j, j - 1);
                    ArrUtils.print(arr);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] arr = new int[] {3, 5, 2, 1};
        ArrUtils.print(arr);
        b.sort(arr);
    }

}
