package leeseungyeol.day5.q14888;

import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void operate(int[] numbers, int[] operators, int index, int result) {

        // 1. 종료조건
        if (index == numbers.length) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // 2. recursive
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        operate(numbers, operators, index + 1, result + numbers[index]);
                        break;
                    case 1:
                        operate(numbers, operators, index + 1, result - numbers[index]);
                        break;
                    case 2:
                        operate(numbers, operators, index + 1, result * numbers[index]);
                        break;
                    case 3:
                        operate(numbers, operators, index + 1, result / numbers[index]);
                        break;
                }

                operators[i]++;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        operate(numbers, operators, 1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
