package com.echo.sort;

import com.echo.utils.ArrUtils;
import sun.jvm.hotspot.utilities.Assert;

/**
 * @author yucheng
 * @description
 * @create 2021-04-02 下午6:13
 */

public class Calculator {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; ++i) {
            int[] arr = ArrUtils.generateIntArr(8, 10);
            BubbleSort bubbleSort = new BubbleSort();
            int[] bubbleArr = ArrUtils.arrCopy(arr);
            bubbleSort.sort(bubbleArr);

            SelectSort selectSort = new SelectSort();
            int[] selectArr = ArrUtils.arrCopy(arr);
            selectSort.sort(selectArr);

            InsertSort insertSort = new InsertSort();
            int[] insertArr = ArrUtils.arrCopy(arr);
            insertSort.sort(insertArr);

            Assert.that(ArrUtils.arrEquals(bubbleArr, selectArr), "计算错误");
            Assert.that(ArrUtils.arrEquals(selectArr, insertArr), "计算错误");

        }
    }
}
