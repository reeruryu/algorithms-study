package dmdwn99.programmers.heap;
import java.util.*;
public class P42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int time = jobs[0][0], start_time = 0, end_time = 0;
        int cnt = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);

        int index = 0;
        boolean work = false;

        while (cnt < jobs.length){
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index++]);
            }
            if (!work && !queue.isEmpty()){
                int[] now = queue.poll();
                start_time = now[0];
                end_time = time + now[1];
                work = true;
            }
            if (end_time == time) {
                answer += time - start_time;
                cnt++;
                work = false;
                if (index < cnt && queue.isEmpty()){
                    time = jobs[index][0];
                }
                continue;
            }
            time++;
        }
        return answer / cnt;
    }
}
