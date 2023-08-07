package leeseungyeol.day3.q49189;

import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        // 1. 빈 그래프 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프 값 넣기
        for (int[] e : edge) {
            int node1 = e[0];
            int node2 = e[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 3. 시작 노드인 1에서 BFS를 수행. -> 배열로 생성.
        int[] distance = bfs(graph, 1, n);

        System.out.println(Arrays.toString(distance));

        // 4.최단 거리가 가장 먼 노드들의 개수를 구함.
        int maxDistance = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                count = 1;
            } else if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }

    private int[] bfs(List<List<Integer>> graph, int start, int n) {

        // 각 노드별 거리
        int[] distance = new int[n + 1];

        // 방문했는지에 대한 노드 체크리스트
        boolean[] visited = new boolean[n + 1];

        // 시작노드 방문 체크
        visited[start] = true;

        // 큐에 방문한 노드들 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);


        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int answer = solution.solution(n, edge);
        System.out.println(answer);
    }
}


