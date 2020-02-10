package com.keep.easy;

import java.util.Arrays;

/**
 * 1.旋转字符串：abcdef 旋转成 cdefab
 * 题目：左旋转字符串
 * 定义字符串的左旋转操作：
 * 把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串abcdef左旋转2位得到字符串cdefab。
 * <p>
 * 请实现字符串左旋转的函数，要求对长度为n的字符串操作的时间复杂度为O(n)，空间复杂度为O(n)
 * <p>
 * 解题思路：挨个移动的时间复杂度是O(N2)，如何做到：时间O（N），空间O（1）
 */
public class 旋转字符 {
    static String targetStr = "a pen I have ";

    public static void moveStr(int index) {
        // 将字符串拆分为字符数组
        char[] targetChar = targetStr.toCharArray();
        // 建立临时变量存储指定位置之前的数据
        char[] tempCharBefore = new char[index];
        char[] tempCharAfter = new char[targetChar.length - index];
        int j = 0;
        for (int i = 0; i < targetChar.length; i++) {
            // 将指定位置前的数据进行保存
            if (i < index) {
                tempCharBefore[i] = targetChar[i];
            }
            // 将指定位置及以后的数据进行保存
            else {
                tempCharAfter[j] = targetChar[i];
                j++;
            }
        }
        for (int i = 0; i < tempCharAfter.length; i++) {
            targetChar[i] = tempCharAfter[i];
        }
        for (int i = 0; i < tempCharBefore.length; i++) {
            targetChar[i + tempCharAfter.length] = tempCharBefore[i];
        }
        System.out.println("将指定的位置：" + index + " 之前的数据旋转到后面的结果为：" + String.valueOf(targetChar));
    }

    public static void moveStr2(String targetStr, int index) {
        // 将字符串拆分为字符数组
        String[] targetChar = {targetStr.substring(0, index), targetStr.substring(index)};
        StringBuilder afterChar = new StringBuilder();
        for (int i = 0; i < targetChar.length; i++) {
            afterChar.append(targetChar[targetChar.length - 1 - i]);
        }
        System.out.println("将指定的位置：" + index + " 之前的数据旋转到后面的结果为：" + afterChar.toString());
    }

    public static void main(String[] arg) {
        moveStr(6);
        moveStr2("a phone I have ", 8);
    }

}
