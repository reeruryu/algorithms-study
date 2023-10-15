package reeruryu.baekjoon.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    마법사 상어와 블리자드
 */
public class B21611 {
    static int answer = 0;
    static int N, M;
    static int[][] map;
    static int[] d, s;
    static int sharkX, sharkY;
    static Position[] positions;

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // ↑, ↓, ←, →
    static int[] dx = {0, 1, 0, -1}; // ←, ↓, →, ↑
    static int[] dy = {-1, 0, 1, 0}; // ←, ↓, →, ↑
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 항상 홀수
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N]; // (1, 1) ~ (N, N) -> (0, 0) ~ (N - 1, N - 1)
        sharkX = sharkY = N / 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d = new int[M];
        s = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken()) - 1;
            s[i] = Integer.parseInt(st.nextToken());
        }

        setPositions();

        for (int i = 0; i < M; i++) {
            int di = d[i];
            int si = s[i];

            // 1. 구슬 파괴
            destroy(di, si);

            // 2. 구슬 이동
            move();

            // 3. 구슬 폭발 없을 때까지 (4개 이상 연속하는 구슬이 있을 때 발생)
            while (explode()) move();

            // 4. 그룹
            map = group();

        }

        System.out.println(answer);

    }

    public static int[][] group() {
        ArrayList<Integer> gList = new ArrayList<>();
        int i = 1;
        while (i < N * N) {
            int num = map[positions[i].x][positions[i].y];
            if (num == 0) break;
            int cnt = 0;

            int j;
            for (j = i; j < N * N; j++) {
                if (num == map[positions[j].x][positions[j].y]) {
                    cnt++;
                } else {
                    break;
                }
            }
            gList.add(cnt);
            gList.add(num);
            i = j;
        }

        int[][] tmpMap = new int[N][N];
        i = 1;
        for (int g : gList) {
            int x = positions[i].x;
            int y = positions[i].y;

            tmpMap[x][y] = g;

            i++;
            if (i >= N * N) break;
        }

        return tmpMap;
    }

    public static boolean explode() {
        boolean flag = false;
        int i = 1;
        while (i < N * N) {
            int num = map[positions[i].x][positions[i].y];
            if (num == 0) break;

            ArrayList<int[]> eList = new ArrayList<>();
            int j;
            for (j = i; j < N * N; j++) {
                if (num == map[positions[j].x][positions[j].y]) {
                    eList.add(new int[]{positions[j].x, positions[j].y});
                } else {
                    break;
                }
            }

            if (eList.size() >= 4) {
                for (int[] t : eList) {
                    map[t[0]][t[1]] = 0;
                }
                flag = true;
                answer += (num * eList.size());
            }

            i = j;
        }

        return flag;
    }

    public static void move() {
        for (int i = 1; i < N * N; i++) {
            int x = positions[i].x;
            int y = positions[i].y;

            if (map[x][y] == 0) {
                for (int k = i + 1; k < N * N; k++) {
                    int nx = positions[k].x;
                    int ny = positions[k].y;
                    if (map[nx][ny] != 0) {
                        map[x][y] = map[nx][ny];
                        map[nx][ny] = 0;
                        break;
                    }
                }
            }
        }
    }

    public static void setPositions() {
        positions = new Position[N * N];
        int x = sharkX;
        int y = sharkY;
        int d = 0;
        int num = 1;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j <= i; j++) {
                x += dx[d];
                y += dy[d];
                positions[num++] = new Position(x, y);
                if (num >= N * N) return;
            }

            d = (d + 1) % 4;
            for (int j = 0; j <= i; j++) {
                x += dx[d];
                y += dy[d];
                positions[num++] = new Position(x, y);
//                if (num >= N * N) break;
            }
            d = (d + 1) % 4;
        }
    }

    public static void destroy(int d, int s) {
        for (int i = 1; i <= s; i++) {
            int nx = sharkX + i * dirs[d][0];
            int ny = sharkY + i * dirs[d][1];
            map[nx][ny] = 0;
        }
    }
}

class Position {
//    int n; // 번호
    int x, y; // 좌표

    public Position(int x, int y) {
//        this.n = n;
        this.x = x;
        this.y = y;
    }
}