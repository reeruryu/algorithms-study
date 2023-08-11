package coze.baekjoon.week1;

import java.util.Scanner;

public class q10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;
        int b = 1;
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            tmp = b;
            b += f;
            f = tmp;
        }

        System.out.println(f);
    }
}
