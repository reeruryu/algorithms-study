package leeseungyeol.day4.q10818;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList <Integer> list = new ArrayList<>();


        for(int i = 0; i<N ;i++) {
            int p = scanner.nextInt();
            list.add(p);
        }

        Collections.sort(list);
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
    }

}