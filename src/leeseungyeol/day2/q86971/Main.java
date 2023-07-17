package leeseungyeol.day2.q86971;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {

        // 1. 빈 그래프 생성 (크기는 n 으로 주어짐)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 주어진 간선을 통해서 그래프 채우기
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println("====================");
        System.out.println(graph);

        // 3. 최소차이 노드 갯수 구하기
        int min = Integer.MAX_VALUE;
        for (int[] wire : wires) {

            // 하나씩 지워보기 시작
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));

            // 지운 후에 bfs 를 통해서 경로길이 BFS 로 체크 (굳이 BFS 를 써야 할까)
            int cnt1 = bfs(graph, a, n);
            int cnt2 = bfs(graph, b, n);

            // 노드개수 차이 체크 후, min 값 없데이트
            int diff = Math.abs(cnt1 - cnt2);
            min = Math.min(min, diff);

            // 다시 채워놓기
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return min;
    }

    // bfs (그래프와, 시작노드, 그리고 노드의 개수)
    private int bfs(List<List<Integer>> graph, int start, int n) {

        // 방문했는지에 대한 노드 체크 리스트 생성
        boolean[] visited = new boolean[n + 1];

        // 시작노드 방문 체크
        visited[start] = true;

        // queue 에 방문한 노드들 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // 모든 연결된 정점의 갯수 찾기.
        int cnt = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int result = solution.solution(n, wires);
        System.out.println(result);  // 3

//        n = 4;
//        wires = new int[][]{{1,2},{2,3},{3,4}};
//        result = solution.solution(n, wires);
//        System.out.println(result);  // 0
//
//        n = 7;
//        wires = new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
//        result = solution.solution(n, wires);
//        System.out.println(result);  // 1
    }
}
