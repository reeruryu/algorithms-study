package reeruryu.programmers.week3;

/*
문제: 프로그래머스 - 큰 수 만들기 / 난이도: Level 2
 */

public class P42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
