package reeruryu.baekjoon.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 { // 아직 안품
    static int max;
    /*static int T, N;
    static int[][] stickers;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N + 1];
            dp = new int[2][N + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }

        System.out.println(sb.toString());
    }*/

}
