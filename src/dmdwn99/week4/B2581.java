package dmdwn99.week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제: 백준 - 소수 / 브론즈2
 */
public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int sum = 0, min = -1, cnt = 0;

        for (int i=x;i<=y;i++) {
            for (int j=2;j<=Math.sqrt(i);j++) {
                if (i % j == 0)
                    cnt++;
            }
            if (cnt == 0 && i != 1) {
                if (min == -1)
                    min = i;
                sum += i;
            }
            cnt = 0;
        }
        if (sum != 0 )
            System.out.println(sum);
        System.out.println(min);
    }
}
