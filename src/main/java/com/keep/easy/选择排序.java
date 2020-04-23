package com.keep.easy;

import java.util.Arrays;

/**
 * 直接选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后， 再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。
 * 实际适用的场合非常罕见。
 */
public class 选择排序 {
    public static void selectSort(int[] array) {
        // 选择序列中最小的元素
        for (int i = 0; i < array.length; i++) {
            // 依次向后比较，比较出最小的元素向前移动
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换位置
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
