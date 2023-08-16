package dmdwn99.baekjoon.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 쉽게 푸는 문제 / 브론즈1
 */
public class B1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int sum = 0, cnt = 1;

        for (int i=1;i<=50;i++) {
            for (int j=0;j<i;j++) {
                if (cnt >= x && cnt <= y)
                    sum += i;
                cnt++;
            }
            if (cnt > y)
                break;
        }
        System.out.println(sum);
    }
}
