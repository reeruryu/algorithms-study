package coze.baekjoon.week2;

import java.util.Scanner;

public class q2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int total = 0;
        int min = 10000;

        for (int i = M; i <= N; i++) {
            if (checkDecimal(i)) {
                total += i;
                min = Math.min(min, i);
            }
        }

        if (total == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(total);
        System.out.println(min);
    }

    public static boolean checkDecimal(int n) {
        if (n <= 1) {
            return false;
        }
        for (int j = 2; j <= n / 2; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
