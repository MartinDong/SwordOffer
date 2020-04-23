package com.keep.easy;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 时间复杂度为 O(n^2)。
 * 是稳定的排序方法。
 * <p>
 * 基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到 一个新的、个数加一的有序数据，算法适用于少量数据的排序，
 * <p>
 * 插入算法把要排序的数组分成两部分：
 * 第一部分 包含了这个数组的所有元素，但将最后一个元素除外（让数组多一个空间才有插 入的位置），
 * 第二部分就只包含这一个元素（即待插入元素）。
 * 在第一部分排序完成后，再将这个最后元素插入到已排好序的第一部分中。
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        insertSort(array);
    }

    private static void insertSort(int[] array) {
        // 从前向后循环
        for (int i = 1; i < array.length; ++i) {
            // 设定下一个数据位置
            int j = i - 1;
            // 取出循环位置的数据
            int temp = array[i];
            // 循环比较，如果当前位置数据小于下一个位置数据，将下下个数据与下个数据交换位置
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
            System.out.println("排序结果：" + Arrays.toString(array));
        }
    }
}
