package leeseungyeol.day2.q42842;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {

        // 1. 정답 배열 생성 (크기는 2 고정)
        int[] answer = new int[2];

        // 2. 문제의 조건 (2(a*b)+4 = brown, a*b = yellow)를 만족하는 값 찾아냄)
        for (int a = 1; a <= brown; a++) {
            for (int b = 1; b <= yellow; b++) {
                if ((((2 * (a + b)) + 4) == brown) && (a * b == yellow)) {
                    answer[0] = b+2;
                    answer[1] = a+2;
                    return answer;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 8;
        int yellow = 1;
        int[] result = solution.solution(brown, yellow);
        System.out.println(Arrays.toString(result));  // [4,3]

        brown = 24;
        yellow = 24;
        result = solution.solution(brown, yellow);
        System.out.println(Arrays.toString(result)); // [8,6]

    }
}