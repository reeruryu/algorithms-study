package leeseungyeol.day2.q42898;


import java.util.*;

class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] a = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int i = puddle[0];
            int j = puddle[1];
            a[j][i] = 1;
        }
        a[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] != 1) {
                    a[i][j] = (a[i - 1][j] + a[i][j - 1]) % 1000000007;
                } else {
                    a[i][j] = 0;
                }
            }
        }
        return a[n][m];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int answer = solution.solution(m, n, puddles);
        System.out.println(answer);
    }
}
