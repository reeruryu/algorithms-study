package leeseungyeol.day3.q49191;

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int INF = 987654321;
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) continue;
                graph[i][j] = INF;
            }
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean isDetermined = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (graph[i][j] == INF && graph[j][i] == INF) {
                    isDetermined = false;
                    break;
                }
            }
            if (isDetermined) answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] edge = {{4,3}, {4,2}, {3,2}, {1, 2}, {2, 5}};
        int answer = solution.solution(n, edge);
        System.out.println(answer);
    }
}


