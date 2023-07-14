package reeruryu;

/*
문제: 프로그래머스 - 다리를 지나는 트럭 / 난이도: Level 2
 */

import java.util.*;

public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<int[]> moveQueue = new LinkedList<>();
        Queue<Integer> waitQueue = new LinkedList<>();

        for (int truckWeight: truck_weights) {
            waitQueue.add(truckWeight);
        }

        int time = 0;
        int totalWeight = 0;
        while (!waitQueue.isEmpty() || !moveQueue.isEmpty()) {
            time++;
            if (moveQueue.isEmpty()) {
                int truckWeight = waitQueue.poll();
                moveQueue.add(new int[]{truckWeight, 1});
                totalWeight += truckWeight;
                continue;
            }

            for (int[] truck: moveQueue) truck[1]++;

            if (moveQueue.peek()[1] > bridge_length) {
                int[] truck = moveQueue.poll();
                totalWeight -= truck[0];
            }

            if (!waitQueue.isEmpty() && totalWeight + waitQueue.peek() <= weight) {
                int truckWeight = waitQueue.poll();
                totalWeight += truckWeight;
                moveQueue.offer(new int[]{truckWeight, 1});
            }

        }

        return time;
    }

}
