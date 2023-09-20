package reeruryu.baekjoon.day5;

/*
문제: 백준 - BOJ 거리
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12026 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = (i - j);
                if (arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + k * k);
                } else if (arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + k * k);
                } else if (arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + k * k);
                }

            }
        }
        System.out.println((dp[N - 1] == Integer.MAX_VALUE) ? -1 : dp[N - 1]);
    }
}
