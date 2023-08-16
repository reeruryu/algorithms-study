package leeseungyeol.day5.q1292;

import java.util.Scanner;

public class Main {

    public static int getNum(int num) {
        int i = 2;
        int n = 1;
        if (num == 1) return 1;
        while (true) {
            if (num > n && num <= n + i) {
                return i;
            }
            n = n + i;
            i++;
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int sum = 0;

//        System.out.println(getNum(p));
//        System.out.println(getNum(q));

        for (int i = p; i <= q; i++) {
            sum += getNum(i);
        }
        System.out.println(sum);
    }

}