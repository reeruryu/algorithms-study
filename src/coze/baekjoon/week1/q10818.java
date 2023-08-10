package coze.baekjoon.week1;

import java.util.Arrays;
import java.util.Scanner;

public class q10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int max = 0;
        int min = 1000000;

        for (int i = 0; i < nums.length; i++) {
            int n = sc.nextInt();
            nums[i] = n;
        }
        Arrays.sort(nums);

        System.out.print(nums[0]+" "+nums[N-1]);
    }
}
