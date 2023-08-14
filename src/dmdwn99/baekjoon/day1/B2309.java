package dmdwn99.baekjoon.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 일곱 난쟁이 / 브론즈1
 */
public class B2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, first = 0, second = 1;
        int[] arr  = new int[9];

        for (int i=0;i<9;i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i=0;i<9;i++) {
            for (int j=i+1; j<9;j++) {
                for (int k=0;k<9;k++) {
                    if (k != first && k != second)
                        sum += arr[k];
                }
                if (sum == 100)
                    break;
                second++;
                sum = 0;
            }
            if (sum == 100)
                break;
            first++;
            second = first + 1;
        }
        for (int i=0;i<9;i++) {
            if (i != first && i != second)
                System.out.println(arr[i]);
        }
    }
}
