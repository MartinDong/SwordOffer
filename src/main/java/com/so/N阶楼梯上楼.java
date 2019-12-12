package com.so;

/**
 * 题目描述
 * N阶楼梯上楼问题：一次可以走两阶或一阶，问有多少种上楼方式。（要求采用非递归）
 * <p>
 * 输入描述:
 * 输入包括一个整数N,(1<=N<90)。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 输出当楼梯阶数是N时的上楼方式个数。
 */
public class N阶楼梯上楼 {
    public static void main(String[] args) {
        //upTheStairs(4);

        System.out.println("上楼的路径有：" + fic(4) + " 种");
    }


    /**
     * 递归方式
     * 思路二：走到第n阶时可能是从第n-1阶走一步到的，
     * 也可能是从n-2阶走两阶到的，
     * 设F(n)为走到n阶的种数，
     * 则F(n)=F(n-1)+F(n-2)。
     * 当n=1时，F(1)=1，n=2时，F(2)=2,这是一个动态规划问题。其实就是一个斐波那契数列。
     *
     * @param n
     */
    public static int fic(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else if (n >= 3) {
            return fic(n - 1) + fic(n - 2);
        } else {
            return -1;//输入n值非法
        }
    }


    /**
     * 非递归方式
     *
     * @param stairsNumber
     */
    public static void upTheStairs(int stairsNumber) {
        long t[] = new long[90];

        for (int i = 0; i < stairsNumber; i++) {
            if (i == 0) {
                t[i] = 1;
            } else if (i == 1) {
                t[i] = 2;
            } else {
                t[i] = t[i - 1] + t[i - 2];
            }
        }
        System.out.println("上楼的路径有：" + t[stairsNumber - 1] + " 种");
    }

}
