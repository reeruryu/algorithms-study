package dmdwn99.week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제: 백준 - 피보자치 수 5 / 브론즈2
 */
public class B10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2;i<=n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]);
    }
}
