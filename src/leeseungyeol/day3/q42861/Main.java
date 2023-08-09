package leeseungyeol.day3.q42861;

import java.util.*;

class Solution {
    int[] parent; // Union-Find 알고리즘을 위한 배열

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기에는 각 노드는 자신을 부모로 가리키도록 설정
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2])); // 가중치 순으로 간선들을 정렬

        int answer = 0; // 최종적으로 반환할 최소 신장 트리의 가중치 합

        for (int[] cost : costs) {
            int from = cost[0]; // 출발지
            int to = cost[1]; // 도착지
            int costValue = cost[2]; // 가중치

            // 출발지와 도착지가 같은 집합에 속하지 않는 경우에만 해당 간선 선택
            if (find(from) != find(to)) {
                union(from, to); // 두 노드를 하나의 집합으로 합치기
                answer += costValue; // 선택한 간선의 가중치를 결과값에 더해줌 (최소 신장 트리 완성)
            }
        }

        return answer; // 최소 신장 트리의 가중치 합 반환
    }

    // Union-Find 알고리즘의 Find 연산
    private int find(int x) {
        if (x == parent[x]) {
            return x; // 자신이 루트 노드인 경우, 자신을 반환
        }
        // 경로 압축 기법을 사용하여 부모 노드를 찾아 올라가며 최종적으로 루트 노드를 반환
        return parent[x] = find(parent[x]);
    }

    // Union-Find 알고리즘의 Union 연산
    private void union(int x, int y) {
        x = find(x); // x의 루트 노드를 찾음
        y = find(y); // y의 루트 노드를 찾음
        if (x != y) {
            parent[y] = x; // 두 집합을 하나의 집합으로 합치기 위해 y의 루트 노드를 x로 설정
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] cost = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int answer = solution.solution(n, cost);
        System.out.println(answer);
    }
}
