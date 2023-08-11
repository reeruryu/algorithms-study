package dmdwn99.week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 소수 찾기 / 브론즈2
 */
public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0, answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for (int j=2;j<=Math.sqrt(tmp);j++) {
                if (tmp % j == 0)
                    cnt++;
            }
            if (tmp != 1 && cnt == 0)
                answer++;
            cnt = 0;
        }
        System.out.println(answer);
    }
}
