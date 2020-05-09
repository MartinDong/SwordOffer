package com.keep.easy;

import java.util.Arrays;

/**
 * 用的不多，时间复杂度比较差，掌握计数排序和基数排序就可以了
 */
public class 桶排序 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        int[] result = bucketSort(array);
        System.out.println("排序结果：" + Arrays.toString(result));
    }

    private static int[] bucketSort(int[] array) {

        return new int[0];
    }

}
