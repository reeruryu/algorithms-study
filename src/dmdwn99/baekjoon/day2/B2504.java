package dmdwn99.baekjoon.day2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 괄호의 값 / 골드5
 */

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        boolean status = false;
        int sum = 0, tmp = 1;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                tmp *= 2;
                status = false;
                cnt++;
            }
            else if (str.charAt(i) == '[') {
                stack.push(str.charAt(i));
                tmp *= 3;
                status = false;
                cnt++;
            }
            else if (str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                if (!status) {
                    sum += tmp;
                    status = true;
                }
                tmp /= 2;
                cnt++;
            }
            else if (str.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
                if (!status) {
                    sum += tmp;
                    status = true;
                }
                tmp /= 3;
                cnt++;
            }
        }
        if (!stack.isEmpty() || cnt != str.length())
            sum = 0;
        System.out.println(sum);
    }
}

