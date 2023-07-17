package reeruryu.week2;

/*
문제: 프로그래머스 - N으로 표현 / 난이도: Level 3
 */

import java.util.*;

public class P42895 {

    static Set<Integer>[] set = new HashSet[9];

    public int solution(int N, int number) {

        int n = 0;
        for (int i = 1; i < 9; i++) {
            n = n * 10 + N;
            set[i] = new HashSet<>();
            set[i].add(n);
        }

        for (int i = 1; i < 9; i++) {
            int a = 1, b = i - a;
            while (a <= b) {
                // System.out.println("a: " + a + ", b: " + b);
                for (int n1: set[a]) {
                    for (int n2: set[b]) {
                        set[i].add(n1 + n2);
                        set[i].add(n1 - n2);
                        set[i].add(n1 * n2);
                        if (n1 != 0) set[i].add(n2 / n1);
                        if (n2 != 0) set[i].add(n1 / n2);
                    }
                }
                a++; b--;
            }

            if (set[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

}
