package reeruryu.baekjoon.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5427 {
    static int n;
    static int w, h;
    static char[][] map;
    static boolean[][] skVisited;
    static boolean[][] fireVisited;
    static Queue<Node> sk;
    static Queue<Node> fire;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            skVisited = new boolean[h][w];
            fireVisited = new boolean[h][w];
            sk = new LinkedList<>();
            fire = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '@') {
                        sk.offer(new Node(j, k));
                        skVisited[j][k] = true;
                    } else if (map[j][k] == '*') {
                        fire.offer(new Node(j, k));
                        fireVisited[j][k] = true;
                    }
                }
            }
            bfs();

        }

        System.out.println(sb.toString());
    }

    public static void bfs() {
        int time = 0;

        while (!sk.isEmpty()) {
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Node cur = fire.poll();

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (!fireVisited[nx][ny] && map[nx][ny] != '#') {
                        fire.offer(new Node(nx, ny));
                        fireVisited[nx][ny] = true;
                    }
                }
            }

            int skSize = sk.size();
            for (int i = 0; i < skSize; i++) {
                Node cur = sk.poll();

                for (int[] dir : dirs) {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        sb.append((time + 1) + "\n");
                        return;
                    }

                    if (!skVisited[nx][ny] && !fireVisited[nx][ny] && map[nx][ny] != '#') {
                        sk.offer(new Node(nx, ny));
                        skVisited[nx][ny] = true;
                    }
                }
            }

            time++;
        }

        sb.append("IMPOSSIBLE\n");

    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
