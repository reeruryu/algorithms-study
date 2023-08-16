package reeruryu.baekjoon.day2;

/*
문제: 백준 - 괄호의 값
https://www.acmicpc.net/problem/2504
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gh = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int tmp = 1;
        int res = 0;
        for (int i = 0; i < gh.length(); i++) {
            char cur = gh.charAt(i);
            if (cur == '(') {
                stack.push(cur);
                tmp *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                tmp *= 3;
            } else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (gh.charAt(i - 1) == '(') res += tmp;
                stack.pop();
                tmp /= 2;
            } else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (gh.charAt(i - 1) == '[') res += tmp;
                stack.pop();
                tmp /= 3;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : res);
    }
}