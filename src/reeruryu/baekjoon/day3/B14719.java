package reeruryu.baekjoon.day3;

/*
문제: 백준 - 빗물
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] blocks = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int amount = 0;
        for (int i = 1; i < W - 1; i++) {
            int cur = blocks[i];
            int leftMax = cur;
            int rightMax = cur;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks[j] > cur) {
                    leftMax = Math.max(leftMax, blocks[j]);
                }
            }
            for (int j = i + 1; j < W; j++) {
                if (blocks[j] > cur) {
                    rightMax = Math.max(rightMax, blocks[j]);
                }
            }
            if (Math.min(leftMax, rightMax) > cur) {
                amount += (Math.min(leftMax, rightMax) - blocks[i]);
            }
        }
        System.out.println(amount);

    }
}
