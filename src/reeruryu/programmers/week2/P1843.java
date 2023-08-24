package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 사칙연산 / 난이도: Level 4
 */

public class P1843 {
    static int[] numbers;
    static String[] operations;
    static int[][][] dp;

    public int solution(String arr[]) {

        int n = arr.length / 2;
        dp = new int[2][200][200];
        numbers = new int[n + 1];
        operations = new String[n];

        // dp 배열 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                // dp[0][][] = 최댓값
                dp[0][i][j] = Integer.MIN_VALUE;

                // dp[1][][] = 최솟값
                dp[1][i][j] = Integer.MAX_VALUE;
            }
        }

        // 숫자와 연산자 분리
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
                continue;
            }
            operations[i / 2] = arr[i];
        }

        return calculate(0, 0, n);
    }

    private static int calculate(int flag, int start, int end) {
        // start == end -> 숫자 하나만 선택된 거이므로 자기자신 반환
        if (start == end) {
            dp[flag][start][end] = numbers[start];
            return dp[flag][start][end];
        }

        // 이미 계산한 경우, return memoization
        if (visited(flag, start, end)) {
            return dp[flag][start][end];
        }

        // 방문 표시
        dp[flag][start][end] = 0;

        // flag = 0 - 최댓값, flag = 1 - 최솟값
        int result = flag == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // 최댓값 -> flag = 0
        if (flag == 0) {
            for (int mid = start; mid < end; mid++) {
                if (operations[mid].equals("-")) {
                    // a-b의 최댓값 -> a는 최댓값, b는 최솟값
                    result = Math.max(result, calculate(0, start, mid) - calculate(1, mid + 1, end));
                } else {
                    // a+b의 최댓값 -> a는 최댓값, b도 최댓값
                    result = Math.max(result, calculate(0, start, mid) + calculate(0, mid + 1, end));
                }
            }
        }

        // 최솟값 -> flag=1
        if (flag == 1) {
            for (int mid = start; mid < end; mid++) {
                if (operations[mid].equals("-")) {
                    // a-b의 최솟값 -> a는 최솟값, b는 최댓값
                    result = Math.min(result, calculate(1, start, mid) - calculate(0, mid + 1, end));
                } else {
                    // a+b의 최솟값 -> a는 최솟값, b도 최솟값
                    result = Math.min(result, calculate(1, start, mid) + calculate(1, mid + 1, end));
                }
            }
        }

        dp[flag][start][end] = result;
        return dp[flag][start][end];
    }

    private static boolean visited(int flag, int start, int end) {
        // flag=0 : MIN, flag=1 : MAX
        // dp값이 초기값인 경우 방문 X
        return dp[flag][start][end] != Integer.MIN_VALUE &&
                dp[flag][start][end] != Integer.MAX_VALUE;
    }


}
