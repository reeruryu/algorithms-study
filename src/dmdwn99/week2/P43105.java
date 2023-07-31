package dmdwn99.week2;
import java.util.*;
public class P43105 {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int[][] dp = new int[h][h];

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + dp[0][0];
        dp[1][1] = triangle[1][1] + dp[0][0];

        for (int i=2;i<h;i++) {
            for (int j=0;j<triangle[i].length;j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][0] + triangle[i][0];
                    continue;
                }

                if (j == triangle[i].length - 1) {
                    dp[i][triangle[i].length - 1] = dp[i-1][triangle[i].length - 2] +
                            triangle[i][triangle[i].length - 1];
                    continue;
                }

                if (dp[i-1][j-1] > dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
            }
        }
        int[] answer = dp[h-1];
        Arrays.sort(answer);
        return answer[h-1];
    }
}
