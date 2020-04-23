package com.keep.easy;

import java.util.Arrays;

/**
 * 快速排序是一种
 * <p>
 * 不稳定 的排序算法，
 * 平均时间复杂度为 O(nlogn)。
 * <p>
 * 快速排序使 用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列 （sub-lists）。
 * <p>
 * 步骤为：
 *  从数列中挑出一个元素，称为"基准"（pivot），
 *  重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准 值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区结束之后， 该基准就处于数列的中间位置。这个称为分区（partition）操作。
 *  递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数 列排序。
 * <p>
 * 快排的时间花费主要在划分上，所以
 *  最坏情况：时间复杂度为 O(n^2)。因为最坏情况发生在每次 划分过程产生的两个区间分别包含 n-1 个元素和 1 个元素的 时候。
 *  最好情况：每次划分选取的基准都是当前无序区的中值。如 果每次划分过程产生的区间大小都为 n/2，则快速排序法运 行就快得多了
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));

        int len = array.length - 1;
        quickSort(array, 0, len);
    }

    /**
     * 快排的优化
     * 1. 当待排序序列的长度分割到一定大小后，使用插入排序。
     * 2. 快排函数在函数尾部有两次递归操作，我们可以对其使用尾递归优化。
     * 优 化后，可以缩减堆栈深度，由原来的 O(n)缩减为 O(logn)，将会提高性能。
     * 3. 从左、中、右三个数中取中间值
     */
    public static int[] quickSort(int[] array, int start, int end) {
        // 基准
        int pivot = array[start];
        // 记录开始位置
        int i = start;
        // 记录结束位置
        int j = end;

        while (i < j) {
            // 从后往前查找大于基准值的数据对应的位置
            while ((i < j) && (array[j] > pivot)) {
                j--;
            }
            // 从前往后查找小于基准值的数据对应的位置
            while ((i < j) && (array[i] < pivot)) {
                i++;
            }
            // 两个数据相同的情况
            if ((array[i] == array[j]) && (i < j)) {
                i++;
            }
            // 两个数据不相同，交换位置
            else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        System.out.println("排序结果：" + Arrays.toString(array));

        // 将排好序的两个序列进行相同的排序操作
        // 取出"基准"前面的列表排序
        if (i - 1 > start)
            array = quickSort(array, start, i - 1);

        // 取出“基准”后面的列表排序
        if (j + 1 < end)
            array = quickSort(array, j + 1, end);

        return (array);
    }


}
