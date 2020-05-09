package com.keep.easy;

import java.util.Arrays;

/**
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 * <p>
 * 先将要进行排序的数组分为两部分，我们叫做Left和Right，
 * 如果我们将这两部分都进行排序完成后，即子数组Left和Right都是有序数组。
 * 那么我们将这两个数组进行合并，合并的方式为，
 * 首先创建一个与原数组容量相同的数组用来存放合并时的数据，
 * 然后比较Left和Right中的数组，如果Left[0]<Right[0]，
 * 将Left[0]放入新数组的0索引处，然后比较Left[1]和Right[0]，
 * 依次类推按照升序或降序的方式便能将Left和Right中所有数组按照一定顺序拷贝进入新数组，
 * 此时就完成了数组排序。
 * <p>
 * 实际上，归并排序的模型中并不是将一个数组只分为两块，
 * 而是分为数组最小单元，再对每个最小单元进行治的处理，
 * 这种处理方式要通过递归思想来进行实现。
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("排序结果：" + Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        // 先创建好一个长度等于原始数组长度的临时数组，避免递归中频繁开辟空间¬
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    // 排序：分
    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            // 根据传入的左右边界计算中间值
            int mid = (left + right) / 2;
            // 左边归并排序，使得左子序列有序
            sort(array, left, mid, temp);
            // 右边归并排序，使得右子序列有序
            sort(array, mid + 1, right, temp);
            // 将两个有序的子数组进行合并操作
            merge(array, left, mid, right, temp);
        }
    }

    // 合并：治
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左序列指针
        int i = left;
        // 右序列指针，中间位置向后移动一个数据
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        // 在左序列索引小于中间位置，右序列是否超出集合大小
        while (i <= mid && j <= right) {
            // 当左序列小于右序列的数据的时候
            if (arr[i] <= arr[j]) {
                // 将左序列存储到临时数组 temp 中，左序列指针向后移动
                temp[t++] = arr[i++];
            }
            // 将右序列存储到临时数组 temp 中，右序列指针向后移动
            else {
                temp[t++] = arr[j++];
            }
        }
        // 将左边剩余元素填充到temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        // 将右边剩余元素填充到temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        // 重置临时数组的指针到头部
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
