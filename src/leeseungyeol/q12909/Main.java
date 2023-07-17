package leeseungyeol.q12909;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(' || s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    answer = false;
                }
            }
//            System.out.println(stack);
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "()()";
        boolean result = solution.solution(s);
        System.out.println(result);  // true

        s = "(())()";
        result = solution.solution(s);
//        System.out.println(result);  // true

        s = ")()(";
        result = solution.solution(s);
//        System.out.println(result);  // false

        s = "(()(";
        result = solution.solution(s);
//        System.out.println(result);  // false
    }
}