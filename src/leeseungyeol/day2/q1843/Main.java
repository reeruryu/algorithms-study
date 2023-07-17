package leeseungyeol.day2.q1843;

 class Solution {
    public static int solution(String[] arr) {
        int n = arr.length;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i += 2) {
            maxDp[i][i] = Integer.parseInt(arr[i]);
            minDp[i][i] = Integer.parseInt(arr[i]);
        }

        for (int len = 2; len < n; len += 2) {
            for (int i = 0; i < n - len; i += 2) {
                int j = i + len;
                maxDp[i][j] = Integer.MIN_VALUE;
                minDp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k += 2) {
                    int a = calculate(maxDp[i][k - 1], arr[k], maxDp[k + 1][j]);
                    int b = calculate(maxDp[i][k - 1], arr[k], minDp[k + 1][j]);
                    int c = calculate(minDp[i][k - 1], arr[k], maxDp[k + 1][j]);
                    int d = calculate(minDp[i][k - 1], arr[k], minDp[k + 1][j]);

                    maxDp[i][j] = Math.max(maxDp[i][j], Math.max(a, Math.max(b, Math.max(c, d))));
                    minDp[i][j] = Math.min(minDp[i][j], Math.min(a, Math.min(b, Math.min(c, d))));
                }
            }
        }

        return maxDp[0][n - 1];
    }

    private static int calculate(int a, String operator, int b) {
        if (operator.equals("+")) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        int answer = solution.solution(arr);
        System.out.println(answer);
    }
}
