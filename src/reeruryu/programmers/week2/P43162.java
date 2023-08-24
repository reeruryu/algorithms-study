package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 네트워크 / 난이도: Level 3
 */

import java.util.*;

public class P43162 {

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int[][] computers, int i) {
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int j = i + 1; j < computers.length; j++) {
                if (!visited[j] && computers[c][j] == 1) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
