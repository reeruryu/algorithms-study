package leeseungyeol.day2.q42895;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);
        }
        System.out.println("==================");
        System.out.println(dp);
        System.out.println("==================");

        for (int i = 1; i <= 8; i++) {

            System.out.println("==================");
            System.out.println(i + "번 사용했을때 :");
            for (int j = 1; j < i; j++) {
                int k = i - j;

                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
                System.out.println(dp);
            }
            System.out.println("==================");

        }

        for (int i = 1; i <= 8; i++) {
            if (dp.get(i).contains(number)) {
                return i; // index
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int N = 5;
        int number = 12;
        int answer = solution.solution(N, number);
        System.out.println(answer);
    }
}
