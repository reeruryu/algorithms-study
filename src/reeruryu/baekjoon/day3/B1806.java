package reeruryu.baekjoon.day3;

/*
문제: 백준 - 부분합
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {
    static int min = Integer.MAX_VALUE;
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0;
        while (right <= N) {
            if (sum >= S) {
                min = Math.min(min, right - left);
                sum -= arr[left++];
            } else {
                if (right == N) break;
                sum += arr[right++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
}
