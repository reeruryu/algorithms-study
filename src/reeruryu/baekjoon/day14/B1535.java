package reeruryu.baekjoon.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = 99;

        int[][] dp = new int[n + 1][k + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) { // n번
            for (int j = 1; j <= k; j++) { // 1~99
                if (w[i] <= j) { // j가 더 크면
                    int rest = j - w[i];
                    dp[i][j] = Math.max(dp[i - 1][rest] + v[i], dp[i - 1][j]);
                } else { // j가 더 작으면
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.print(dp[n][k]);
    }
}
