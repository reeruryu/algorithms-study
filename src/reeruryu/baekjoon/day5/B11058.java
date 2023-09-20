package reeruryu.baekjoon.day5;

/*
문제: 백준 - 크리보드
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11058 {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i > 6) {
                for (int j = 2; j < 5; j++) {
                    dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
