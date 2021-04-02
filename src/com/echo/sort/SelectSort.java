package com.echo.sort;

import com.echo.utils.ArrUtils;

/**
 * @author yucheng
 * @description
 * @create 2021-03-30 下午7:00
 */

public class SelectSort {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            ArrUtils.swap(arr, i, minIndex);
            ArrUtils.print(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectSort s = new SelectSort();
        int[] arr = ArrUtils.generateIntArr(5, 6, 10);
        ArrUtils.print(arr);
        s.sort(arr);
    }
}
