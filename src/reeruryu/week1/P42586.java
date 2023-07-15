package reeruryu.week1;

/*
문제: 프로그래머스 - 기능개발 / 난이도: Level 2
 */

import java.util.*;

public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++)
            queue.offer((100 - progresses[i] + speeds[i] - 1) / speeds[i]);

        int cnt = 1;
        int now = queue.poll();
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (now >= next) cnt++;
            else {
                answer.add(cnt);
                now = next;
                cnt = 1;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
