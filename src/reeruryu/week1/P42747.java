package reeruryu.week1;

/*
문제: 프로그래머스 - H-Index / 난이도: Level 2
 */

import java.util.Arrays;

public class P42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
