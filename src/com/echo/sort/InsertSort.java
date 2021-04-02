package com.echo.sort;

import com.echo.utils.ArrUtils;

/**
 * @author yucheng
 * @description
 * @create 2021-04-02 下午4:28
 */

public class InsertSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j > 0 && j < arr.length; --j) {
                if (arr[j - 1] > arr[j]) {
                    ArrUtils.swap(arr, j - 1, j);
                }
                ArrUtils.print(arr);
            }
            System.out.println("-------");
        }
    }

    public static void main(String[] args) {
        InsertSort s = new InsertSort();
        int[] arr = ArrUtils.generateIntArr(8,10);
        ArrUtils.print(arr);
        s.sort(arr);
    }
}
