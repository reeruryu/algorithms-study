package dmdwn99.baekjoon.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제: 백준 - 이진수 / 브론즈3
 */
public class B3460 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j=0;x!=0;j++) {
                if (x%2 == 1)
                    System.out.print(j + " ");
                x /= 2;
            }
            System.out.println();
        }
    }
}
