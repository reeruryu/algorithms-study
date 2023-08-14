package reeruryu.week4;

/*
문제: 백준 - 소수 찾기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978 {
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;

        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) cnt++;
        }
        System.out.println(cnt);
    }
}
