package dmdwn99.baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제: 백준 - 줄 세우기 / 골드3
 */
public class B2252 {
    static int n;
    static int m;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cnt = new int[n+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            cnt[b]++;
        }

        topologicalSort(graph);
    }
    private static void topologicalSort(ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1;i<=n;i++) {
            if (cnt[i] == 0) {
                queue.add(i);
                System.out.print(i + " ");
            }
        }
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            ArrayList<Integer> list = graph.get(tmp);
            for (int i=0;i< list.size();i++) {
                cnt[list.get(i)]--;
                if (cnt[list.get(i)] == 0) {
                    queue.add(list.get(i));
                    System.out.print(list.get(i) + " ");
                }
            }
        }
    }
}
