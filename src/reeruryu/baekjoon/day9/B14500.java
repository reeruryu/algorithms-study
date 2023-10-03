package reeruryu.baekjoon.day9;

import java.util.*;
import java.io.*;

public class B14500 {

    static int max = Integer.MIN_VALUE;
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        arr = new int[n][m];
        visited = new boolean[n][m];

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solve(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int[] dir : dirs) {
            int nx = row + dir[0];
            int ny = col + dir[1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (!visited[nx][ny]) {

                // (ㅗ) 만들기 위해
                if (depth == 2) {
                    visited[nx][ny] = true;
                    solve(row, col, arr[nx][ny] + sum, depth + 1);
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                solve(nx, ny, arr[nx][ny] + sum, depth + 1);
                visited[nx][ny] = false;
            }

        }

    }
}
