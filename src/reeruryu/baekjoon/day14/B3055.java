package reeruryu.baekjoon.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {
    static int R, C;
    static char[][] map;
    static Queue<Node> water = new LinkedList<>();
    static Queue<Node> dochi = new LinkedList<>();
    static boolean[][] dochiVisited;
    static boolean[][] waterVisited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        dochiVisited = new boolean[R][C];
        waterVisited = new boolean[R][C];

        /*
            비어있는 곳은 '.'로 표시되어 있고,
            물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다.
            비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
         */
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') { // 고슴도치
                    dochi.offer(new Node(i, j));
                    dochiVisited[i][j] = true;
                } else if (map[i][j] == '*') { // 물
                    water.offer(new Node(i, j));
                    waterVisited[i][j] = true;
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        int time = 0;

        while (!dochi.isEmpty()) {
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Node cur = water.poll();

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (!waterVisited[nx][ny] && map[nx][ny] != 'D' && map[nx][ny] != 'X') {
                        water.offer(new Node(nx, ny));
                        waterVisited[nx][ny] = true;
                    }
                }
            }

            int dochiSize = dochi.size();
            for (int i = 0; i < dochiSize; i++) {
                Node cur = dochi.poll();

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == 'D') {
                        System.out.println(time + 1);
                        System.exit(0);
                    }
                    if (!dochiVisited[nx][ny] && !waterVisited[nx][ny] && map[nx][ny] != 'X') {
                        dochi.offer(new Node(nx, ny));
                        dochiVisited[nx][ny] = true;
                    }
                }
            }

            time++;
        }

        System.out.println("KAKTUS");
        System.exit(0);

    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
