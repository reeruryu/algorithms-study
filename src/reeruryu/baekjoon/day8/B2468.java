package reeruryu.baekjoon.day8;

/*
문제: 백준 - 안전영역
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {
    static int N;
    static int answer = 1;
    static boolean[][] visited;
    static int[][] region;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        region = new int[N][N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(region[i][j], max);
            }
        }

        // 1. dfs
        /*for (int i = 1; i <= max; i++) {
            visited = new boolean[N][N];
            int ans = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && region[j][k] > i) {
                        dfs(i, j, k);
                        ans++;
                    }
                }
            }
            answer = Math.max(ans, answer);
        }*/

        // 2. bfs
        for (int i = 1; i <= max; i++) {
            visited = new boolean[N][N];
            int ans = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && region[j][k] > i) {
                        bfs(i, j, k);
                        ans++;
                    }
                }
            }
            answer = Math.max(ans, answer);
        }

        System.out.println(answer);
    }

    public static void dfs(int water, int x, int y) {
        visited[x][y] = true;

        for (int[] d: dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!visited[nx][ny] && region[nx][ny] > water) dfs(water, nx, ny);

        }
    }

    public static void bfs(int water, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int[] d: dirs) {
                int nx = c[0] + d[0];
                int ny = c[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (!visited[nx][ny] && region[nx][ny] > water) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
