package coze.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q42627 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int index = 0;
        int cnt = 0;
        int total = 0;
        int end = 0;
        while (cnt < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.offer(jobs[index]);
                index++;
            }

            if (pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] current = pq.poll();
                total += current[1] + end - current[0];
                end += current[1];
                cnt++;
            }
        }
        return total / jobs.length;
    }
}
