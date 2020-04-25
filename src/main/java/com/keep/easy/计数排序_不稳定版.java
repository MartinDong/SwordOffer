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
public class 计数排序_不稳定版 {

    public static void main(String[] args) {
        int[] array = new int[]{22, 18, 21, 15, 27, 16, 23, 10, 24, 10, 13, 12, 11, 14, 16, 19, 10, 21, 22};
        System.out.println("原始数据：" + Arrays.toString(array));
        System.out.println("排序结果：" + Arrays.toString(countSort(array)));
    }

    private static int[] countSort(int[] array) {
        // 最后的排序结果
        int[] result = new int[array.length];
        // 这里的大小取决于原始集合最大的数字+1
        int[] count = new int[findMax(array) + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        System.out.println("排序计数：" + Arrays.toString(count));

        // 输出每个位置应该对应的数字，这里因为初始化count的时候是按照最大的数字初始化的容量，所以每个位置数据记录的都是这个位置的数据含有的个数
        for (int i = 0, j = 0; i < count.length; i++) {
            // 依次取出，如果当前位置记录的数据大于0表示含有这个数据，循环的记录到result中，此时的i代表的就是这个数据，while循环多少次就是含有几个
            while (count[i]-- > 0) {
                result[j++] = i;
            }
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
