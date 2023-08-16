package reeruryu.week4;

/*
문제: 백준 - 최대공약수와 최소공배수
*/

import java.util.Scanner;

public class B2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int gcd = gcd(n1, n2);
        int lcm = n1 * n2 / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;

        return gcd(n2, n1 % n2);
    }
}
