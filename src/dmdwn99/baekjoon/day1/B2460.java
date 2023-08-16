package dmdwn99.baekjoon.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 지능형 기차 2 / 브론즈3
 */
public class B2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, max = -1;

        for (int i=0;i<10;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            sum += in - out;
            if (sum > max)
                max = sum;
        }
        System.out.println(max);
    }
}
