package reeruryu.baekjoon.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16397 {
    static int N, T, G;
    static boolean[] visited = new boolean[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == G) {
                System.out.println(cur[1]);
                return;
            }

            if (cur[1] + 1 > T) continue;

            // 1. A
            int A = cur[0] + 1;
            if (A < 100000 && !visited[A]) {
                visited[A] = true;
                queue.add(new int[]{A, cur[1] + 1});
            }

            // 2. B
            int B = cur[0] * 2;
            if (B > 0 && B < 100000) {
                String s = String.valueOf(B);
                B -= (int)Math.pow(10, s.length() - 1);
                if (!visited[B]) {
                    visited[B] = true;
                    queue.add(new int[]{B, cur[1] + 1});
                }
            }

        }

        System.out.println("ANG");
    }
}
