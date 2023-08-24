package reeruryu.week4;

/*
문제: 백준 - N번째 큰 수
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2693 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            A = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            System.out.println(A[7]);
        }

    }
}
