package reeruryu.baekjoon.day7;

/*
문제: 시험 감독
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13458 {
    static int N;
    static int[] A;
    static int B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 시험장 개수
        A = new int[N]; // 응시자 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken()); // 총감독관 감시 수
        C = Integer.parseInt(st.nextToken()); // 부감독관 감시 수

        long total = N;
        for (int i = 0; i < N; i++) {
            // 총감독관 무조건 한명 필요
            A[i] -= B;

            // 부감독관으로 나머지 채우기
            if (A[i] > 0) {
                total += A[i] / C;
                if (A[i] % C != 0) total++;
            }
        }

        System.out.println(total);
        //2,147,483,647
        //1,000,000 * 1,000,000

    }
}
