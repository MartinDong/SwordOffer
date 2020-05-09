package com.keep.easy;

import java.util.Arrays;

/**
 * 快速排序是一种
 * <p>
 * 不稳定 的排序算法，
 * 平均时间复杂度为 O(nlogn)。
 * <p>
 * 给基准数据找其正确索引位置的过程.
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

//        // 设两个指示标志:low 指向起始位置，high 指向末尾.
//        int low = 0;
//        int high = array.length - 1;
//        System.out.println("quickSort原始数据：" + Arrays.toString(array));
//        quickSort(array, low, high);
//        System.out.println("quickSort排序结果：" + Arrays.toString(array));

        int[] array2 = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("quickSort2原始数据：" + Arrays.toString(array2));
        quickSort2(array2, 0, array2.length - 1);
        System.out.println("quickSort2排序结果：" + Arrays.toString(array2));
    }


    /**
     * ①先从队尾开始向前扫描且当low < high时,如果a[high] > tmp,
     * * 则high–,但如果a[high] < tmp,则将high的值赋值给low,
     * * 即arr[low] = a[high],同时要转换数组扫描的方式,
     * * 即需要从队首开始向队尾进行扫描了
     * ②同理,当从队首开始向队尾进行扫描时,如果a[low] < tmp,
     * * 则low++,但如果a[low] > tmp了,
     * * 则就需要将low位置的值赋值给high位置,
     * * 即arr[low] = arr[high],同时将数组扫描方式换为由队尾向队首进行扫描.
     * ③不断重复①和②,知道low>=high时(其实是low=high),
     * * low或high的位置就是该基准数据在数组中的正确索引位置.
     */
    public static int[] quickSort2(int[] array, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(array, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使得整个数组变成有序的
            // 基准值之前的数据
            quickSort2(array, 0, index - 1);
            // 基准值之后的数据
            quickSort2(array, index + 1, high);
        }
        return array;
    }


    /**
     * @param arr  要排序的序列
     * @param low  低位
     * @param high 高位
     * @return 基准数据位置
     */
    public static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当对队尾的元素大于等于基准数据时，向前挪动 high 指针（位置）
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于 tmp 了，需要将其赋值给 low
            arr[low] = arr[high];
            // 当队首元素小于等于 tmp 时，向前挪动 low 指针（位置）
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于 tmp 时，需要将其赋值给 high
            arr[high] = arr[low];
        }
        // 跳出循环的时候哦，low 和 high 相等，此时的 low 或 high 就是 tmp 的正确索引位置
        // 由原理部分可以很清楚的知道，low 位置的值并不是 tmp ，所以只需要将 tmp 赋值给 arr[low]
        arr[low] = tmp;
        // 返回 tmp 的正确位置¬
        return low;
    }


    /**
     * 快排的优化
     * 1. 当待排序序列的长度分割到一定大小后，使用插入排序。
     * 2. 快排函数在函数尾部有两次递归操作，我们可以对其使用尾递归优化。
     * 优 化后，可以缩减堆栈深度，由原来的 O(n)缩减为 O(logn)，将会提高性能。
     * 3. 从左、中、右三个数中取中间值
     */
    public static int[] quickSort(int[] array, int low, int high) {
        // 基准数据
        int pivot = array[low];
        // 记录开始位置
        int i = low;
        // 记录结束位置
        int j = high;

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
        //System.out.println("排序结果：" + Arrays.toString(array));

        // 将排好序的两个序列进行相同的排序操作
        // 取出"基准"前面的列表排序
        if (i - 1 > low)
            array = quickSort(array, low, i - 1);

        // 取出“基准”后面的列表排序
        if (j + 1 < high)
            array = quickSort(array, j + 1, high);

        return array;
    }

}
