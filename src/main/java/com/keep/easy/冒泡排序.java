package com.keep.easy;

import java.util.Arrays;

/**
 * 冒泡排序
 * 稳定的排序算法
 * 平均时间复杂度 O(n^2)
 * <p>
 * 它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他 们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数 列已经排序完成。
 * <p>
 *  比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *  对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
 * 在这 一点，最后的元素应该会是最大的数。
 * <p>
 *  针对所有的元素重复以上的步骤，除了最后一个。
 *  持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要 比较。
 */
public class 冒泡排序 {

    public static void bubbleSort(int[] array) {

        // 从前往后依次比较，如果返现比后面的数据大，则交换数据位置，继续下次循环
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("排序结果：" + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        bubbleSort(array);
    }
}
