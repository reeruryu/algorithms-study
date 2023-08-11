package leeseungyeol.day4.q2460;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();


        int now = 0;
        int cnt = 1;

        while (cnt <= 10) {
            int out = scanner.nextInt();
            int in = scanner.nextInt();
            now = now - out + in;
            list.add(now);
            cnt++;
        }

//        System.out.println(list);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));

    }

}