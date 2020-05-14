package com.leet.code;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("排序结果：" + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        // 循环第一层
        for (int i = 0; i < array.length; i++) {
            // 循环第二层
            for (int j = i + 1; j < array.length; j++) {
                // 拿第一层的数据与第二层的每一个数据比较，如果出现了第二层的数据小于第一层的数据，
                // 则交换数据位置
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
