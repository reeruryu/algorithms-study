package coze.baekjoon.week2;

import java.util.Scanner;

public class q1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] sequence = new int[1001];
        int cnt = 1;
        int result = 0;

        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                if (cnt >= 1001) break;
                sequence[cnt] = i;
                cnt++;
            }
        }

        for (int i = a; i <= b; i++) {
            result += sequence[i];
        }

        System.out.println(result);
    }
}
