package reeruryu.programmers.week3;

/*
문제: 프로그래머스 - 순위 / 난이도: Level 3
 */

public class P49191 {
    static int[][] floyd;
    public int solution(int n, int[][] results) {
        int answer = 0;
        floyd = new int[n + 1][n + 1];

        for (int[] result : results) {
            int u = result[0];
            int v = result[1];
            floyd[u][v] = 1;
            floyd[v][u] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }

                    if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (floyd[i][j] != 0) cnt++;
            }
            if (cnt == n - 1) answer++;
        }

        return answer;
    }
}
