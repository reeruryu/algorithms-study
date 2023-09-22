package reeruryu.baekjoon.day5;

/*
문제: 백준 - 평범한 배낭
*/

import java.io.*;
import java.util.*;

public class B12865 {

    static int[] W;
    static int[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        W = new int[N + 1];
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

//        W V
//        6 13
//        4 8
//        3 6
//        5 12
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                if (W[i] > j) { // i번째 무게를 더 담을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                } else { // i번째 무게를 더 담을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
