package reeruryu.baekjoon.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {
    static int answer = 0;
    static int N, M;
    static int[][] region;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        region = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (region[i][j] == 0) {
                    region[i][j] = 1;
                    dfs(cnt + 1);
                    region[i][j] = 0;
                }
            }
        }

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (region[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // copy
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = region[i].clone();
        }

        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (tmp[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    tmp[nx][ny] = 2;
                }
            }
        }

        // 안전영역 크기 세기
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) ans++;
            }
        }
        answer = Math.max(ans, answer);
    }
}