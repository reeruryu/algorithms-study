package reeruryu.week1;

/*
문제: 프로그래머스 - 더 맵게 / 난이도: Level 2
 */

import java.util.*;

public class P42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s: scoville) {
            pq.add(s);
        }

        if (pq.peek() >= K) return 0;

        int cnt = 0;
        while (pq.size() > 1) {
            int newFood = pq.poll() + pq.poll() * 2;
            pq.add(newFood);
            cnt++;

            if (pq.peek() >= K) return cnt;
        }

        return -1;
    }
}
