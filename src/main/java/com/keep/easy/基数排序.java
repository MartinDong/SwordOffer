package com.keep.easy;

import java.util.Arrays;

/**
 * 多关键字的排序
 * 稳定的排序，
 * 平均时间复杂度 O(k*n)
 * 空间复杂度O(n)
 * 本身还是桶排序思想
 * <p>
 * <p>
 * 对于有 d 个关键字时，可以分别按关键字进行排序。
 * 有俩种方法：
 *  MSD：先从高位开始进行排序，在每个关键字上，可采用基数排序
 *  LSD：先从低位开始进行排序，在每个关键字上，可采用桶排序，即通过每个数的每位数字的大小来比较
 */
public class 基数排序 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
        System.out.println("原始数据：" + Arrays.toString(array));
        int[] result = cardinalNumberSort(array);
        System.out.println("排序结果：" + Arrays.toString(result));

    }

    /**
     * 低位优先LSD
     */
    private static int[] cardinalNumberSort(int[] array) {
        // 定义结果集合
        int[] result = new int[array.length];
        // 用来循环记录的集合，这里的集合大小与存储数据的最大数+1相等
        int[] count = new int[10];
        // 循环2次，注意：应该是按照数据的最高位的位数进行循环
        for (int i = 0; i < 2; i++) {
            // 进行位数分隔用的，如果是大于
            int division = (int) Math.pow(10, i);
            System.out.println("division===" + division);
            // 循环原始数组
            for (int j = 0; j < array.length; j++) {
                //
                int num = array[j] / division % 10;
                // 进行总数的记录
                count[num]++;
            }
            System.out.println("=========================");
            System.out.println(Arrays.toString(count));

            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }
            System.out.println("=========================");
            System.out.println(Arrays.toString(count));

            for (int j = array.length - 1; j >= 0; j--) {
                int num = array[j] / division % 10;
                result[--count[num]] = array[j];
            }
            System.arraycopy(result, 0, array, 0, array.length);
            Arrays.fill(count, 0);
        }
        return result;
    }

}
