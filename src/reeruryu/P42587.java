package reeruryu;

/*
문제: 프로그래머스 - 프로세스 / 난이도: Level 2
 */

import java.util.PriorityQueue;

public class P42587 {
    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        for (int priority : priorities) {
            pq.add(priority);
        }

        int cnt = 1;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) return cnt;
                    pq.poll();
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
