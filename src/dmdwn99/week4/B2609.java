package dmdwn99.week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 최대공약수와 최소공배수 / 브론즈1
 */
public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int max = 0, min = 0;

        for (int i=1;i<=x*y;i++) {
            if (x % i == 0 && y % i == 0) {
                if (max < i)
                    max = i;
            }
            if (i % x == 0 && i % y == 0) {
                min = i;
                break;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
