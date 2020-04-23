package com.keep.easy;

import java.util.Arrays;

public class 选择排序 {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int minNum = array[i];
            array[i] = array[minIndex];
            array[minIndex] = minNum;

            System.out.println("排序结果：" + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 8, 1, 5, 7, 6, 3, 0, 4, 9};
        System.out.println("原始数据：" + Arrays.toString(array));
        selectSort(array);
    }
}
