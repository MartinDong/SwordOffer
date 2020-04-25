package com.keep.easy;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * 平均时间复杂度 O(nlogn)
 * 是不稳定的排序
 * <p>
 * 利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征，
 * 使得在当前无序区中选取最大（或最小）关键字的记录变得简单。
 * 1. 将数组分为有序区和无序区，在无序区中建立最大堆
 * 2. 将堆顶的数据与无序区末尾的数据交换
 * 3. 从后往前，直到所有数据排序完成
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        heapSort(array);
    }

    private static void heapSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            // 建立最大堆
            maxHeap(array, 0, i);
            swap(array, 0, i);
            System.out.println("排序结果：" + Arrays.toString(array));
        }
    }

    private static void maxHeap(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int parent = start;
        int childLeft = start * 2 + 1;
        int childRight = childLeft + 1;

        if (childLeft <= end) {
            maxHeap(array, childLeft, end);

            if (array[childLeft] > array[parent]) {
                swap(array, parent, childLeft);
            }
        }

        if (childRight <= end) {
            maxHeap(array, childRight, end);

            if (array[childRight] > array[parent]) {
                swap(array, parent, childRight);
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
