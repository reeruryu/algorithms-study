package reeruryu.baekjoon.day3;

/*
문제: 백준 - 최소비용 구하기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    static ArrayList<Edge>[] graph;
    static int[] d;
//    static boolean[] visited;
//    static int[][] matrix;
    static int N, M;

    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        d = new int[N + 1];
//        visited = new boolean[N + 1];
//        matrix = new int[N + 1][N + 1];
        graph = new ArrayList[N + 1]; // <> X라고 컴파일 에러 조심하기 ;
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//            matrix[u][v] = w;
//            matrix[v][u] = w;
            graph[u].add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(d[end]);

    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (d[cur.to] < cur.weight) continue; // 시간 초과 주의

            for (Edge next : graph[cur.to]) {
                int newDist = cur.weight + next.weight;

                if (d[next.to] > newDist) {
                    d[next.to] = newDist;
                    pq.offer(new Edge(next.to, newDist));
                }
            }
        }
    }
}
