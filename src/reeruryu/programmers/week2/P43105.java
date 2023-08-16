package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 정수 삼각형 / 난이도: Level 3
 */

import java.util.*;

public class P43105 {
    public int solution(int[][] triangle) {

        int i;
        for (i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i + 1].length; j++) {
                int max = 0;
                if (j == 0) {
                    max = triangle[i][j];
                } else if (j == triangle[i + 1].length - 1) {
                    max = triangle[i][j - 1];
                } else {
                    max = Math.max(triangle[i][j - 1], triangle[i][j]);
                }
                triangle[i + 1][j] += max;
            }
        }

        return Arrays.stream(triangle[i]).max().getAsInt();
    }
}
