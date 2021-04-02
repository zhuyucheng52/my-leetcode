package com.echo.utils;

/**
 * @author yucheng
 * @description
 * @create 2021-03-24 下午4:56
 */

public class ArrUtils {
    /**
     * 判断给定两个数组内容是否一样
     * @param indexs1 数组1
     * @param indexs2 数组2
     * @return
     */
    public static boolean arrEquals(int[] indexs1, int[] indexs2) {
        if (indexs1.length != indexs2.length) {
            return false;
        }

        for (int i = 0; i < indexs1.length; ++i) {
            if (indexs1[i] != indexs2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成指定长度的整数数组
     * @param minLength 最短长度(包含)
     * @param maxLength 最长长度(不包含)
     * @param maxValue  最大值(不包含)
     * @return
     */
    public static int[] generateIntArr(int minLength, int maxLength, int maxValue) {
        int length = (int) (Math.random() * (maxLength - minLength)) + minLength;
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     *
     * @param length
     * @param maxValue
     * @return
     */
    public static int[] generateIntArr(int length, int maxValue) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 生成小写字符数组
     * @param minLength
     * @param maxLength
     * @return
     */
    public static char[] generateCharArr(int minLength, int maxLength) {
        int length = (int) (Math.random() * (maxLength - minLength)) + minLength;
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; ++i) {
            int random = (int) (Math.random() * (int) ('z' - 'a' + 1));
            arr[i] = (char) (random + 'a');
        }
        return arr;
    }

    /**
     * 生成字符串
     * @param minLength
     * @param maxLength
     * @return
     */
    public static String generateStr(int minLength, int maxLength) {
        return new String(generateCharArr(minLength, maxLength));
    }

    /**
     * 打印数组
     * @param indexs
     */
    public static void print(int[] indexs) {
        for (int i = 0; i < indexs.length; ++i) {
            System.out.print(indexs[i] + "\t");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
