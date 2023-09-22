package reeruryu.baekjoon.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16197 {
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] arr;
    static int[] coin1;
    static int[] coin2;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        arr = new char[N][M];
        visited1 = new boolean[N][M];
        visited2 = new boolean[N][M];

        int cnt = 0;
        coin1 = new int[2];
        coin2 = new int[2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (cnt == 0 && arr[i][j] == 'o') {
                    coin1[0] = i;
                    coin1[1] = j;
                    cnt++;
                } else if (cnt == 1 && arr[i][j] == 'o') {
                    coin2[0] = i;
                    coin2[1] = j;
                    cnt++;
                }
            }
        }

        dfs(coin1[0], coin1[1], coin2[0], coin2[1], 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int x1, int y1, int x2, int y2, int cnt) {

        if (cnt >= 10) return;

        if ((x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) &&
                (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M)) {
            return;
        }

        if ((x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) ||
                (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M)) {
            min = Math.min(min, cnt);
            return;
        }

        for (int[] d : dirs) {
            int newX1 = x1 + d[0];
            int newY1 = y1 + d[1];

            int newX2 = x2 + d[0];
            int newY2 = y2 + d[1];

            if (arr[newX1][newY1] == '#' || arr[newX2][newY2] == '#') continue;

            if (!visited1[newX1][newY1] && !visited2[newX2][newY2]) {
                visited1[newX1][newY1] = true;
                visited2[newX2][newY2] = true;
                dfs(newX1, newY1, newX2, newY2, cnt + 1);
                visited1[newX1][newY1] = false;
                visited2[newX2][newY2] = false;
            }

        }

    }

}