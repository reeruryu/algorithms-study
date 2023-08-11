package leeseungyeol.day4.q3460;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();

        for (int i = 0; i < p; i++) {
            int q = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (q != 0) {
                list.add(q % 2);
                q = q / 2;
            }
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 1) {
                    System.out.println(j);
                }
            }
        }
    }

}