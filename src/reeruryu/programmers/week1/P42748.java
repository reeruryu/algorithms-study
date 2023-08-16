package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - K번째수 / 난이도: Level 1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P42748 {
    public int[] solution(int[] array, int[][] commands) {

        List<Integer> answer = new ArrayList<>();

        for (int[] command: commands) { // 1~50
            List<Integer> list = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) { // 1~100
                list.add(array[i]);
            }
            Collections.sort(list);
            answer.add(list.get(command[2] - 1));
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
