package reeruryu.baekjoon.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15684 {
    static int n, m, h;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        h = Integer.parseInt(t[2]);
        map = new int[h + 1][n + 2];

        for (int i = 0; i < m; i++) {
            String [] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);
            int b = Integer.parseInt(tt[1]);
            map[a][b] = 1;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(0, i, 1);
        }
        System.out.println(-1);
    }

    public static void dfs(int level, int num, int col) {
        if (level > num) return;
        if (level == num && isPossible()) {
            System.out.println(level);
            System.exit(0);
        }

        for (int i = col; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    dfs(level + 1, num, i);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static boolean isPossible() {
        for (int i = 1; i <= n; i++) {
            int line = i;
            int col = 1;
            while (col != h + 1) {
                if (map[col][line] == 1) line++;
                else if (map[col][line - 1] == 1) line --;

                col++;
            }

            if (line != i) return false;
        }
        return true;
    }
}