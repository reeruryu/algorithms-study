package reeruryu.week1;

/*
문제: 프로그래머스 - 이중우선순위큐 / 난이도: Level 3
 */

import java.util.*;

public class P42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x, y) -> y - x);

        for (String operation: operations) {
            char o = operation.charAt(0);
            int n = Integer.parseInt(operation.substring(2));

            if (o == 'I') {
                minQueue.add(n);
                maxQueue.add(n);
            } else {
                if (minQueue.isEmpty() || maxQueue.isEmpty()) continue;
                if (n == -1) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                } else {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
            }
        }

        if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}
