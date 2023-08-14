package dmdwn99.programmers.dp;

public class P42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;

        for (int i=0;i<puddles.length;i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            map[x][y] = -1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++) {
                if (map[i][j] == -1 || (i==1&&j==1)) {
                    continue;
                }
                int sum = 0;
                if (map[i-1][j] != -1)
                    sum += map[i-1][j];

                if (map[i][j-1] != -1)
                    sum += map[i][j-1];

                map[i][j]=sum%1000000007;
            }
        }
        return map[n][m]%1000000007;
    }
}
