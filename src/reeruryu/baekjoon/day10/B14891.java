package reeruryu.baekjoon.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891 {
    static int[][] t = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                t[i][j] = s.charAt(j) - '0';
            }
        }

        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            operate(idx, dir);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += Math.pow(2, i) * t[i][0];
        }
        System.out.println(score);

    }

    public static void operate(int idx, int dir) {
        leftOperate(idx - 1, -dir);
        rightOperate(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void leftOperate(int idx, int dir) {
        if (idx < 0) return;
        if (t[idx][2] == t[idx + 1][6]) return;
        leftOperate(idx - 1, -dir);
        rotate(idx, dir);
    }

    static void rightOperate(int idx, int dir) {
        if (idx > 3) return;
        if (t[idx - 1][2] == t[idx][6]) return;
        rightOperate(idx + 1, -dir);
        rotate(idx, dir);
    }

    static void rotate(int idx, int dir) {
        if (dir == 1) { // 시계 방향
            int tmp = t[idx][7];
            for (int i = 7; i > 0; i--) {
                t[idx][i] = t[idx][i - 1];
            }
            t[idx][0] = tmp;
        } else {
            int tmp = t[idx][0];
            for (int i = 0; i < 7; i++) {
                t[idx][i] = t[idx][i + 1];
            }
            t[idx][7] = tmp;
        }
    }

}
