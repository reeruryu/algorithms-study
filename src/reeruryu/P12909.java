package reeruryu;

/*
문제: 프로그래머스 - 올바른 괄호 / 난이도: Level 2
 */

import java.util.*;

public class P12909 {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
