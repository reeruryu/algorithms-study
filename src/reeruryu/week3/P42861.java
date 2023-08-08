package reeruryu.week3;

/*
문제: 프로그래머스 - 섬 연결하기 / 난이도: Level 3
 */

import java.util.Arrays;

public class P42861 {
    static int[] island;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        island = new int[n];
        for (int i = 0; i < n; i++) {
            island[i] = i;
        }

        for (int[] cost: costs) {
            int u = findUnion(cost[0]);
            int v = findUnion(cost[1]);
            System.out.println(cost[0] +" "+u+", "+cost[1]+" "+v);
            if (u != v) {
                answer += cost[2];
                island[u] = v;
            }

        }

        return answer;
    }

    public static int findUnion(int u) {
        if (island[u] == u) return u;
        return findUnion(island[u]);
    }
}
