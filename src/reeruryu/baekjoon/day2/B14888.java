package reeruryu.baekjoon.day2;

/*
문제: 백준 - 연산자 끼워넣기
*/

import java.util.Scanner;

public class B14888 {
    static int N;
    static int[] A;
    static int[] operators = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(A[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int res, int cur) {
        if (cur == N) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:	dfs(res + A[cur], cur + 1);	break;
                    case 1:	dfs(res - A[cur], cur + 1);	break;
                    case 2:	dfs(res * A[cur], cur + 1);	break;
                    case 3:	dfs(res / A[cur], cur + 1);	break;
                }
                operators[i]++;
            }
        }

    }
}
