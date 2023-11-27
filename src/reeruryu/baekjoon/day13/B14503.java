package reeruryu.baekjoon.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
    static int cnt = 1;
    static int N, M;
    static int r, c, d;
    static int[][] room;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);

    }

    public static void clean(int r, int c, int d) {
        room[r][c] = -1; // 청소

        // 현재 위치에서 반시계 방향으로 차례대로 체크
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = r + dirs[d][0];
            int ny = c + dirs[d][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            // 청소 안되어 있으면
            if (room[nx][ny] == 0) {
                cnt++;
                clean(nx, ny, d);
                return;
            }
        }

        // 네 방향 모두 청소가 되어 있거나 벽일 때
        int back = (d + 2) % 4;
        int bx = r + dirs[back][0];
        int by = c + dirs[back][1];

        if (bx < 0 || by < 0 || bx >= N || by >= M) return;
        if (room[bx][by] != 1) clean(bx, by, d);

    }
}