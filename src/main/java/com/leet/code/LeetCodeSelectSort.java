package com.leet.code;

import java.util.Arrays;

/**
 * 选择排序
 */
public class LeetCodeSelectSort {


    public static void selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int minNum = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = minNum;

            System.out.println("result=" + Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 8, 1, 5, 7, 6, 3, 0, 4, 9};
        selectSort(nums);
    }
}
