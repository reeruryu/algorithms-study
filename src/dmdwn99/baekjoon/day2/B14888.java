package dmdwn99.baekjoon.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 연산자 끼워넣기 / 실버1
 */
public class B14888 {
    public static Long max, min;
    public static int[] arr;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int plus, minus, multiple, divide;
        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiple = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());
        calculate(1, plus, minus, multiple, divide,Long.valueOf(arr[0]));
        System.out.println(max);
        System.out.println(min);
    }
    public static void calculate(int i, int plus, int minus, int multiple, int divide, Long sum) {
        if (n == i) {
            if (max == null || max < sum)
                max = sum;
            if (min == null || min > sum)
                min = sum;
            return;
        }
        if (plus > 0)
            calculate(i+1, plus-1, minus, multiple, divide, sum+Long.valueOf(arr[i]));
        if (minus > 0)
            calculate(i+1, plus, minus-1, multiple, divide, sum-Long.valueOf(arr[i]));
        if (multiple > 0)
            calculate(i+1, plus, minus, multiple-1, divide, sum*Long.valueOf(arr[i]));
        if (divide > 0)
            calculate(i+1, plus, minus, multiple, divide-1, sum/Long.valueOf(arr[i]));
    }
}
