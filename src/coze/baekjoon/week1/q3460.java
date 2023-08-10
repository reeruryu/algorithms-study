package coze.baekjoon.week1;

import java.util.Scanner;

public class q3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int check = 0;
        int location = 0;

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            while (true) {
                check = n % 2;
                n = n / 2;

                if (check == 1) {
                    System.out.print(location);
                    if (n == 0) break;
                    System.out.print(" ");
                }
                location++;
            }
            location = 0;
            System.out.println();
        }
    }
}
