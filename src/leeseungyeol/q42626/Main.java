package leeseungyeol.q42626;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }

            int num1 = pq.poll();
            int num2 = pq.poll();

            int rst = num1 + (num2 * 2);
            pq.add(rst);
            answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int K = 7;
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int result = solution.solution(scoville,K);
        System.out.println(result);  // 8
    }
}