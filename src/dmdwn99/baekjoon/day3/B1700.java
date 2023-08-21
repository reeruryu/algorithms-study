package dmdwn99.baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
문제: 백준 - 멀티탭 스케줄링 / 골드1
 */
public class B1700 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] used = new boolean[k+1];
        int[] sequence = new int[k];

        int cnt = 0, answer = 0, idx = 0;

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<k;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sequence[i] = tmp;
        }

        for (int i=0;i<k;i++) {
            if (n==cnt) {
                idx = i;
                break;
            }
            if (!used[sequence[i]]) {
                used[sequence[i]] = true;
                cnt++;
            }
        }

        for (int i=idx;i<k;i++) {
            if (used[sequence[i]])
                continue;
            boolean[] check = new boolean[k+1];
            cnt = 0;
            for (int j=i+1;j<k;j++) {
                if (cnt == n-1)
                    break;
                if (used[sequence[j]] && !check[sequence[j]]) {
                    check[sequence[j]] = true;
                    cnt++;
                }
            }
            for (int j=1;j<=k;j++) {
                if (used[j] && !check[j]){
                    used[j] = false;
                    used[sequence[i]] = true;
                    break;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
