package coze.baekjoon.week2;

import java.util.Scanner;

public class q1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (checkDecimal(n)) {
                cnt++;
            }
        }
        System.out.println(cnt);
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
