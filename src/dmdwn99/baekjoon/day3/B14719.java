package dmdwn99.baekjoon.day3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 빗물 / 골드5
 */
public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        int answer = 0;

        boolean left = false, right = false;

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<w;i++) {
            int tmp = Integer.parseInt(st.nextToken());

            for (int j=0;j<tmp;j++)
                map[h-1-j][i] = 1;
        }

        for (int i=0;i<h;i++) {
            for (int j=1;j<w-1;j++) {
                if (map[i][j] == 1)
                    continue;
                for (int k=0;k<j;k++) {
                    if (map[i][k] == 1) {
                        left = true;
                        break;
                    }
                }
                for (int k=j+1;k<w;k++) {
                    if (map[i][k] == 1) {
                        right = true;
                        break;
                    }
                }
                if (left && right)
                    answer++;
                left = false;
                right = false;
            }
        }

        System.out.println(answer);
    }
}
