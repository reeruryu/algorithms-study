package leeseungyeol.day5.q1978;

import java.util.*;

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

        int N = scanner.nextInt();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int p = scanner.nextInt();
            if (primeNum(p)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}