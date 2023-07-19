package reeruryu.week2;

/*
문제: 프로그래머스 - 게임 맵 최단거리 / 난이도: Level 2
 */

import java.util.*;

public class P1844 {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> queue = new LinkedList<>();
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        bfs(maps, 0, 0);

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }

    public void bfs(int[][] maps, int x, int y) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();

            if (xy[0] == n && xy[1] == m) return;

            for (int[] d: directions) {
                int newX = xy[0] + d[0];
                int newY = xy[1] + d[1];

                if (newX < 0 || newX > n || newY < 0 || newY > m) continue;
                if (maps[newX][newY] == 0) continue;

                if (maps[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY});
                    maps[newX][newY] = maps[xy[0]][xy[1]] + 1;
                }

            }
        }

    }

}
