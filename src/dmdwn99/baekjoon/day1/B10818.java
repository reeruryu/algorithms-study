package dmdwn99.baekjoon.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 최소, 최대 / 브론즈3
 */
public class B10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0;i<n;i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }
        Arrays.sort(arr);
        System.out.print(arr[0] + " ");
        System.out.print(arr[n-1]);
    }
}
