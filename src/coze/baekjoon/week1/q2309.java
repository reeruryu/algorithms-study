package coze.baekjoon.week1;

import java.util.Arrays;
import java.util.Scanner;

public class q2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            int h = sc.nextInt();
            total += h;
            height[i] = h;
        }

        int remain = total - 100;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] + height[j] == remain) {
                    height[i] = 0;
                    height[j] = 0;
                    Arrays.sort(height);

                    for (int k = 2; k < height.length; k++) {
                        System.out.println(height[k]);
                    }
                    return;
                }
            }
        }
    }
}
