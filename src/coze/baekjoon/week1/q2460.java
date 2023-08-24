package coze.baekjoon.week1;

import java.util.Scanner;

public class q2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int now = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();

            now -= out;
            max = Math.max(max, now);
            now += in;
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}
