package com.keep.easy;

import java.util.Arrays;

/**
 * 希尔排序是 非稳定排序算法。
 * 平均时间复杂度 O(nlogn)
 * <p>
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
 * <p>
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，
 * 当增量减至 1 时，整个文件恰被分成一组，算法便终止.
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        shellSort(array);
    }

    private static void shellSort(int[] array) {
        // 确定步长
        int step = array.length;

        // 步长大于0就继续循环
        while (step > 0) {
            // 每次增量减半
            step /= 2;
            // 循环每次拆分的集合进行插入排序，也就是将大集合的插入排序每次都拆分成了多个小的集合处理
            for (int i = 0; i < step; i++) {
                // 这里其实就是一个插入排序
                for (int j = i + step; j < array.length; j += step) {
                    // 用于交换数据的中间变量
                    int temp = array[j];
                    int k = j - step;
                    while (k >= 0 && temp < array[k]) {
                        array[k + step] = array[k];
                        k -= step;
                    }
                    array[k + step] = temp;
                    System.out.println("排序结果：" + Arrays.toString(array));
                }
            }
        }
    }
}
