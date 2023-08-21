package dmdwn99.baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
문제: 백준 - 최소 스패닝 트리 / 골드4
 */
public class B1197 {
    static int[] parent;
    public static int find(int a){
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a!=b)
            parent[b] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v+1];
        for (int i=0;i<=v;i++)
            parent[i] = i;

        int[][] graph = new int[e][3];

        for (int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, (e1, e2) -> e1[2] - e2[2]);

        for (int i=0;i<e;i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                answer += graph[i][2];
            }
        }
        System.out.println(answer);
    }
}
