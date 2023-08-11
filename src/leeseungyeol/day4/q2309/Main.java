package leeseungyeol.day4.q2309;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = 1;
        int sum = 0;
        while (cnt != 10) {
            int p = scanner.nextInt();
            list.add(p);
            sum += p;
            cnt++;
        }

        Collections.sort(list);

        Integer a = 0;
        Integer b = 0;

        for (int i = 0; i <= list.size() - 1; i++) {
            for (int j = i + 1; j <= list.size() - 1; j++) {
                if (sum - list.get(i) - list.get(j) == 100) {
                    a = list.get(i);
                    b = list.get(j);
                }
            }
        }

        list.remove(a);
        list.remove(b);

        for(int i: list){
            System.out.println(i);
        }
    }

}