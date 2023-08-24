package dmdwn99.baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
문제: 백준 - 최소비용 구하기 / 골드5
 */
public class B1916 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] edge = new int[m][3];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        dist[start] = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (dist[edge[j][0]] != INF && dist[edge[j][1]] > dist[edge[j][0]] + edge[j][2]) {
                    dist[edge[j][1]] = dist[edge[j][0]] + edge[j][2];
                }
            }
        }
        System.out.println(dist[finish]);
    }
}
