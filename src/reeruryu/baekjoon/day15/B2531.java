package reeruryu.baekjoon.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2531 {
    static int N, D, K, C;
    static int[] sushi;
    static int[] eat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        eat = new int[D + 1];
        System.out.println(check());

    }

    public static int check() {
        // init
        int count = 0;
        int max = 0;
        for (int i = 0; i < K; i++) {
            int s = sushi[i];

            if (eat[s] == 0) count++;
            eat[s]++;
        }
        max = count;

        // 2 pointer
        for (int i = 0; i < N - 1; i++) {
            if (count >= max) {
                if (eat[C] == 0) max = count + 1;
                else max = count;
            }

            // -
            eat[sushi[i]]--;
            if (eat[sushi[i]] == 0) count--;

            // +
            if (eat[sushi[(i + K) % N]] == 0) count++;
            eat[sushi[(i + K) % N]]++;

        }

        return max;

    }
}
