package leeseungyeol.day5.q2693;

import java.util.*;
public class Main {

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int p = scanner.nextInt();
                list.add(p);
            }
            Collections.sort(list);
            System.out.println(list.get(7));
        }

    }

}