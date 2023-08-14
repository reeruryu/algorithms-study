package dmdwn99.programmers.heap;
import java.util.*;
public class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0;i<scoville.length;i++){
            priorityQueue.add(scoville[i]);
        }
        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) return -1;
            int new_scoville = priorityQueue.poll() + (priorityQueue.poll() * 2);
            priorityQueue.add(new_scoville);
            answer++;
        }
        return answer;
    }
}
