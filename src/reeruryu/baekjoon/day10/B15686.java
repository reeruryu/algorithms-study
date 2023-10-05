package reeruryu.baekjoon.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {
    static int ans = Integer.MAX_VALUE;
    static int N, M;
    static int[][] city;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N x N
        M = Integer.parseInt(st.nextToken()); // 치킨집 개수는 최대 M개
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) house.add(new int[]{i, j});
                else if (city[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        visited = new boolean[chicken.size()];

        solution(chicken.size(), 0);
        System.out.println(ans);

    }

    public static void solution(int open, int idx) {
        if (open == M) {
            ans = Math.min(calcDist(), ans);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(open - 1, i);
                visited[i] = false;
            }
        }
    }

    public static int calcDist() {
        int distance = 0;
        for (int[] h : house) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (!visited[i]) {
                    int[] c = chicken.get(i);
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(min, d);
                }

            }
            distance += min;
        }

        return distance;
    }
}
