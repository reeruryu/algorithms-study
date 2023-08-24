package dmdwn99.baekjoon.day3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
문제: 백준 - 부분합 / 골드4
 */
public class B1806 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int sum = 0, min = 0, start = 0, idx = 0, cnt = 0;
        int[] arr = new int[n];
        boolean flag = false;

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp >= s) {
                System.out.println(1);
                return;
            }
            if (sum < s) {
                sum += tmp;
            }
            if (sum >= s && !flag) {
                start = i;
                flag = true;
                min = i+1;
            }
            arr[i] = tmp;
        }
        if (!flag) {
            System.out.println(0);
            return;
        }
        for (int i=start;i<n;i++) {
            if (i != start)
                sum += arr[i];
            for (int j = idx;j < i; j++) {
                if (sum - arr[j] < s){
                    idx = j;
                    min = Math.min(min, i + 1 - j);
                    break;
                }
                sum -= arr[j];
                cnt++;
            }
            cnt = 0;
        }

        System.out.println(min);
    }
}