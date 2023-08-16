package reeruryu.programmers.week3;

/*
문제: 프로그래머스 - 구명보트 / 난이도: Level 2
 */

import java.util.Arrays;

public class P42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            answer++;
        }

        return answer;
    }
}
