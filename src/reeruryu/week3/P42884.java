package reeruryu.week3;

/*
문제: 프로그래머스 - 단속카메라 / 난이도: Level 3
 */

import java.util.Arrays;

public class P42884 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cam = Integer.MIN_VALUE;
        for (int[] route: routes) {
            if (cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }
}
