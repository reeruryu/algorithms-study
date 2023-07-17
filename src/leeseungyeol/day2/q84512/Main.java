package leeseungyeol.day2.q84512;

import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;

        // 1. 각가이 가지는 자릿수별 weights 들 산정 (노가다)
        int[] weights = {781, 156, 31, 6, 1};
        int len = word.length();

        // 2. 각 문자의 인덱스 위치와 가중치를 곱하고 답을 구함
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            answer += "AEIOU".indexOf(ch) * weights[i] + 1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word = "AAAAE";
        int result = solution.solution(word);
        System.out.println(result);  // 6

        word = "AAAE";
        result = solution.solution(word);
        System.out.println(result);  // 10

        word = "I";
        result = solution.solution(word);
        System.out.println(result);  // 1563

        word = "EIO";
        result = solution.solution(word);
        System.out.println(result);  // 1189
    }
}