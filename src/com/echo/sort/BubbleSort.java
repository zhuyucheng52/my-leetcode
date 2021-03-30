package com.echo.sort;

import java.util.SortedMap;

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
                    swap(arr, j, j - 1);
                    print(arr);
                }
            }
        }
        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] arr = new int[] {3, 5, 2, 1};
        print(arr);
        int[] sortedArr = b.sort(arr);
        print(sortedArr);

    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
