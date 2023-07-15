package coze;

import java.util.PriorityQueue;

public class q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovillePq = new PriorityQueue<>();
        for (int num : scoville) {
            scovillePq.offer(num);
        }
        while (scovillePq.peek() < K) {
            if (scovillePq.size() == 1) {
                return -1;
            }
            scovillePq.offer(scovillePq.poll() + scovillePq.poll() * 2);
            answer++;
        }
        return answer;
    }
}
