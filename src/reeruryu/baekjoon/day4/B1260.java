package reeruryu.baekjoon.day4;

/*
문제: 백준 - DFS와 BFS
*/

import java.io.*;
import java.util.*;

public class B1260 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(list[i]);

        // dfs
        dfs(V);
        System.out.println();

        // bfs
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for (int next : list[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V); // offer할 때 visit check!!
        visited[V] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : list[cur]) {
                if (!visited[next]) {
                    q.offer(next); // offer할 때 visit check!!
                    visited[next] = true;
                }
            }
        }
    }

}
