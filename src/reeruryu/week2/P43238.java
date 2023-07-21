package reeruryu.week2;

/*
문제: 프로그래머스 - 입국심사 / 난이도: Level 3
 */

import java.util.Arrays;

public class P43238 {
    public long solution(int n, int[] times) {
        // n: 1 ~ 1,000,000,000
        // time: 1 ~ 1,000,000,000
        // times.length: 1 ~ 100,000
        long answer = 0;

        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int time: times) {
                sum += mid / time;
            }

            if (sum >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }

        }

        return answer;
    }
}
