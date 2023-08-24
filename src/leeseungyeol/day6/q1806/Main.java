package leeseungyeol.day6.q1806;

import java.util.Scanner;

// ## 부분합 문제 -> 투포인터 문
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 숫자들 길이
        int S = scanner.nextInt();  // 합

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < N) {
            sum += numbers[right];

            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= numbers[left++];
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);  // 만족하는 부분합이 없는 경우
        } else {
            System.out.println(minLength);
        }
    }
}
