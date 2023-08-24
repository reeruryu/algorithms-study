package coze.programers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class q42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {
            String[] operation = s.split(" ");
            if (minHeap.isEmpty() && operation[0].equals("D")) {
                continue;
            }
            if (operation[0].equals("I")) {
                minHeap.offer(Integer.parseInt(operation[1]));
                maxHeap.offer(Integer.parseInt(operation[1]));
            } else if (s.equals("D -1")) {
                int min = minHeap.poll();
                maxHeap.remove(min);
            } else {
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
        }

        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}
