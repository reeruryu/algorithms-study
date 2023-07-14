package reeruryu;

/*
문제: 프로그래머스 - 디스크 컨트롤러 / 난이도: Level 3
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class P42627 {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (x, y) -> x[0] - y[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        int cnt = 0;
        int time = 0;
        int jobsIdx = 0;
        while (cnt < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= time) {
                pq.add(jobs[jobsIdx]);
                jobsIdx++;
            }

            if (pq.isEmpty()) {
                time = jobs[jobsIdx][0];
                continue;
            }

            int[] job = pq.poll();
            answer += job[1] + time - job[0];
            time += job[1];
            cnt++;

        }

        return (int) (answer / jobs.length);
    }
}
