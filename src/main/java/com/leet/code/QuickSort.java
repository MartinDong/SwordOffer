package com.leet.code;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("排序结果：" + Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取基准值的位置
            int index = getIndex(arr, low, high);
            // 遍历基准值前面的数据
            quickSort(arr, 0, index - 1);
            // 遍历基准值后面的数据
            quickSort(arr, index + 1, high);
        }
    }

    public static int getIndex(int[] arr, int low, int high) {
        // 取出临时的基准值
        int tmp = arr[low];
        // 判断低位是否小于高位
        while (low < high) {
            // 先从后向前循环，找到那个比临时基准值小的数据的角标
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 然后将这个数据移动到 low 的位置上
            arr[low] = arr[high];
            // 然后从前向后循环，找到那个比基准值大的数据的角标
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 然后将这个数据移动到 high 的位置上
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }
}
