package coze.baekjoon.week2;

import java.util.Scanner;

public class q2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tmp = 0;

        tmp = a;
        a = Math.max(a, b);
        b = Math.min(tmp, b);

        System.out.println(gcd(a, b));
        System.out.println((a * b) / gcd(a, b));
    }

    public static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
