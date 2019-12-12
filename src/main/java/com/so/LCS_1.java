package com.so;

public class LCS_1 {
    public static void main(String[] args) {
        LCS_1 lcs = new LCS_1();
        String str = lcs.getLSC("acbcbcedaf", "abscbcedabcdefgcbcedafaaaabbsbsb");
        System.out.println(str);
    }

    private String getLSC(String A, String B) {
        int[][] dp = new int[A.length()][B.length()];
        int end_index = 0;
        int maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {

                if (B.charAt(j) == A.charAt(i)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end_index = j;
                    }
                }
            }
        }
        System.out.println("maxLength = " + maxLength);
        System.out.println("end_index = " + end_index);
        end_index += 1;
        return B.substring(end_index - maxLength, end_index);
    }
}