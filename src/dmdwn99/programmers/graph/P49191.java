package dmdwn99.programmers.graph;

public class P49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] x =  new int[n][n];

        for (int i=0;i<results.length;i++) {
            int win = results[i][0]-1;
            int lose = results[i][1]-1;
            x[win][lose] = 1;
            x[lose][win] = -1;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (x[i][j] == 1) {
                    for (int k=0;k<n;k++) {
                        if (x[j][k] == 1) {
                            x[i][k] = 1;
                            x[k][i] = -1;
                        }
                    }
                }
                if (x[i][j] == -1) {
                    for (int k=0;k<n;k++) {
                        if (x[j][k] == -1) {
                            x[i][k] = -1;
                            x[k][i] = 1;
                        }
                    }
                }
            }
        }

        for (int i=0;i<n;i++) {
            int cnt=0;
            for (int j=0;j<n;j++) {
                if (x[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == n-1)
                answer++;
        }
        return answer;
    }
}
