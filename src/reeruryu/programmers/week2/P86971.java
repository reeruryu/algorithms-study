package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 전력망을 둘로 나누기 / 난이도: Level 2
 */

import java.util.*;

public class P86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire: wires) {
            int u = wire[0];
            int v = wire[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int[] wire: wires) {
            int u = wire[0];
            int v = wire[1];

            graph[u].remove(Integer.valueOf(v));
            graph[v].remove(Integer.valueOf(u));

            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(graph, 1, visited);
            answer = Math.min(answer, Math.abs((n - cnt) - cnt));

            graph[u].add(v);
            graph[v].add(u);
        }

        return answer;
    }

    public int dfs(ArrayList<Integer>[] graph, int cur, boolean[] visited) {
        visited[cur] = true;
        int cnt = 1;

        for (int next: graph[cur]) {
            if (!visited[next]) {
                cnt += dfs(graph, next, visited);
            }
        }

        return cnt;
    }
}
