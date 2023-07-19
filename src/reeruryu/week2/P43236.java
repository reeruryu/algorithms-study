package reeruryu.week2;

/*
문제: 프로그래머스 - 징검다리 / 난이도: Level 4
 */

import java.util.Arrays;

public class P43236 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        int left = 0;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            int prev = 0;
            for (int rock : rocks) {
                if (rock - prev < mid) cnt++;
                else prev = rock;
            }

            if (distance - prev < mid)
                cnt++;

            if (cnt <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return answer;
    }
}
