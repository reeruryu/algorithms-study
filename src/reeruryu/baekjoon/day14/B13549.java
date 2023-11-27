package reeruryu.baekjoon.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 {
    static int N, K;
    static boolean[] isVisited = new boolean[100001];

    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs(N);

    }

    static void bfs(int start) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(start, 0));

        while (!pq.isEmpty()) {
            Pos p = pq.poll();

            int nowX = p.x;
            int nowCnt = p.cnt;
            isVisited[nowX] = true;
            if (nowX == K) {
                System.out.println(nowCnt);
                return;
            }

            int jump = nowX * 2;
            if (jump < 100001 && !isVisited[jump]) {
                pq.add(new Pos(jump, nowCnt));
            }

            for (int t = 0; t < 2; t++) {
                int nx = nowX + dx[t];

                if (nx >= 0 && nx <= 100000 && !isVisited[nx]) {
                    pq.add(new Pos(nx, nowCnt + 1));
                }
            }
        }

    }

    static class Pos implements Comparable<Pos>{
        int x, cnt;

        Pos(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }

        // 오름차순으로 넣음 (시간이 더 적게 걸리는 것이 더 앞으로 오게)
        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }
}
