package com.keep.easy;

/**
 * 1. 求a+(a+b)-(a+2b)+(a+3b)-(a+4b)...+(a+nb)的和，其中a、b、n是整数。
 */
public class 求abn {

    // a+(a+b)-(a+2b)+(a+3b)-(a+4b)...+(a+nb)
    // (a+0b)+(a+1b)  -  (a+2b)+(a+3b)  -  (a+4b)+(a+5b) -  ...  (a+(n-1)b)+(a+nb)
    // 2a+1b  -  2a+5b   -  2a+9b - ... -  2a+[(n-1)+n]b
    // 1+1+1-1+2+1+3
    static int a = 1;
    static int b = 1;
    static int count;
    // 字符串拼接
    static StringBuilder processStr = new StringBuilder();

    public static int getCount(int n) {
        //a+n*b
        if (n == 0) {
            processStr.append("+").append(a);
            return count = count + a;
        } else if (n % 2 == 0) {//偶数
            count = count - (a + n * b);
            processStr.append("-(").append(a).append("+").append(n).append("*").append(b).append(")");
            return getCount(n - 1);
        } else {//基数
            processStr.append("+(").append(a).append("+").append(n).append("*").append(b).append(")");
            count = count + (a + n * b);
            return getCount(n - 1);
        }
    }

    // 反向拼接公式
    public static String getProcessStr() {
        String temp = processStr.toString();
        if (temp.charAt(0) == 43 || temp.charAt(0) == 45) {
            temp = temp.substring(1, temp.length());
        }
        char[] tempArray = temp.toCharArray();

        processStr = new StringBuilder();
        for (int i = tempArray.length - 1; i >= 0; i--) {
            if (tempArray[i] == ')') {
                processStr.append("(");
            } else if (tempArray[i] == '(') {
                processStr.append(")");
            } else {
                processStr.append(tempArray[i]);
            }
        }
        return processStr.toString();
    }

    public static void main(String[] args) {
        int result = getCount(3);
        // 1+(1*1+1)+(1*2+1)-(1*3+1)=4
        System.out.println(getProcessStr() + "=" + result);
    }

}
