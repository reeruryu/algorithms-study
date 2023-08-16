package leeseungyeol.day5.q2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack <Character> stack = new Stack<>();

        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // 1. case1.
            if (c == '(') {
                tmp *= 2;
                stack.push('(');
            } else if (c == '[') {
                tmp *= 3;
                stack.push('[');
            }
            // 2. case2.
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if (i > 0 && s.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                tmp /= 2;
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (i > 0 && s.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
