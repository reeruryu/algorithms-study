package reeruryu.baekjoon.day2;

/*
문제: 백준 - 쉽게 푸는 문제
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int idx = 1;
        int num = 1;
        int sum = 0;
        while (idx <= end) {
            for (int j = 0; j < num; j++) {
                if (idx >= start) sum += num;
                if (++idx > end) break;
            }
            num++;
        }
        System.out.println(sum);

    }
}
