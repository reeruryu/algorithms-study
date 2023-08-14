package leeseungyeol.day5.q2581;


import java.util.Scanner;

public class Main {

    public static boolean primeNum(int a) {
        if (a < 2) return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = p; i <= q; i++) {
            if (primeNum(i)) {
                sum += i;
                if (min > i) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

}