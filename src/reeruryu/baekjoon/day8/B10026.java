package reeruryu.baekjoon.day8;

/*
문제: 백준 - 적록색약
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10026 {

    static int N;
    static char[][] region;
    static boolean[][] visited, visitedRG;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        region = new char[N][N];
        visited = new boolean[N][N];
        visitedRG = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                region[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        int cntRG = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, region[i][j]);
                    cnt++;
                }

                if (!visitedRG[i][j]) {
                    dfsRG(i, j, region[i][j]);
                    cntRG++;
                }
            }
        }

        System.out.println(cnt + " " + cntRG);

    }

    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int[] d: dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (color != region[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, color);
        }
    }

    public static void dfsRG(int x, int y, char color) {
        visitedRG[x][y] = true;

        for (int[] d: dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visitedRG[nx][ny]) continue;
            if ((color == 'R' || color == 'G') && region[nx][ny] == 'B') continue;
            if ((color == 'B') && (region[nx][ny] == 'R' || region[nx][ny] == 'G')) continue;

            visitedRG[nx][ny] = true;
            dfsRG(nx, ny, color);
        }
    }
}
