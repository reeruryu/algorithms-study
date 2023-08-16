package coze.baekjoon.week2;

import java.util.Arrays;
import java.util.Scanner;

public class q2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[10];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 10; j++) {
                int n = sc.nextInt();
                nums[j] = n;
            }
            Arrays.sort(nums);
            System.out.println(nums[7]);
        }
    }
}
