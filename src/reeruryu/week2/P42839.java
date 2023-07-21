package reeruryu.week2;

/*
문제: 프로그래머스 - 소수 찾기 / 난이도: Level 2
 */

import java.util.*;

public class P42839 {
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, "", 0, i);
        }

        int cnt = 0;
        for (int number: set) {
            if (isPrime(number)) cnt++;
        }

        return cnt;
    }

    public void permutation(String str, String newStr, int depth, int end) {
        if (depth == end) {
            set.add(Integer.parseInt(newStr));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
//                System.out.println(newStr);
                permutation(str, newStr + str.charAt(i), depth + 1, end);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;

        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }

        return true;
    }

}
