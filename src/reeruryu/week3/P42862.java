package reeruryu.week3;

/*
문제: 프로그래머스 - 체육복 / 난이도: Level 1
 */

import java.util.Arrays;

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int l : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((l - 1 == reserve[j]) || (l + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;

                }
            }
        }

        return answer;
    }

}
