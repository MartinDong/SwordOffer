package com.keep.easy;

import java.util.Arrays;

/**
 * 桶排序的一种
 * 空间复杂度：N+K
 * K代表的是桶，用来记录数据出现了多少次
 * 平均时间复杂度：O(n+k)
 * <p>
 * 非比较排序
 * 使用场景：针对特定的问题，也就是原数据的区间不是很大，且数量不是很多，比如年龄排序划分
 * <p>
 * 直接计算数据在集合中的存在的个数，然后直接写在另一个集合中
 */
public class 计数排序_稳定版 {

    public static void main(String[] args) {
        int[] array = new int[]{5,3,1,4,5,2,1};
        System.out.println("原始数据：" + Arrays.toString(array));
        System.out.println("排序结果：" + Arrays.toString(countSort(array)));
    }

    private static int[] countSort(int[] array) {
        // 最后的排序结果
        int[] result = new int[array.length];
        // 这里的大小取决于原始集合最大的数字+1
        int[] count = new int[findMax(array) + 1];
        int[] temp = new int[findMax(array) + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        System.out.println("角标数组：" + Arrays.toString(temp));
        System.out.println("排序计数：" + Arrays.toString(count));

        // 将计数数据转化成累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println("结束位置：" + Arrays.toString(count));

        // 倒序遍历原始数列
        for (int i = array.length - 1; i >= 0; i--) {
            // 从原始数据中的获取数据对应到记录位置的累加数组中
            // 这里使用完计数位置的数据后并进行及减减操作，即下一个同样数据的位置
            int lastIndex = --count[array[i]];
            System.out.println("结束位置：" + Arrays.toString(count));
            result[lastIndex] = array[i];
        }

        return result;
    }

    // 找到最大的那个数来确定计数序列的容器大小
    private static int findMax(int[] array) {
        int maxNum = 0;

        for (int value : array) {
            if (value > maxNum) {
                maxNum = value;
            }
        }

        return maxNum;
    }
}
