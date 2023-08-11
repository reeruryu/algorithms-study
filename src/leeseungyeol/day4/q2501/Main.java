package leeseungyeol.day4.q2501;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 1; i <= p; i++) {
            if (p % i == 0) {
                list.add(i);
            }
        }

        if (list.size() < q) {
            System.out.println(0);
        } else {
            System.out.println(list.get(q - 1));
        }
    }

}