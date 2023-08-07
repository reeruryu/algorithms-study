package leeseungyeol.day3.q42883;

import java.util.*;

class Solution {
    public String solution(String number, int k) {

        int length = number.length();
        int answerLength = length - k;
        char[] result = new char[answerLength];

        Stack<Character> stack = new Stack<>();

        // 1. 최대 숫자 생성
        for (int i = 0; i < length; i++) {

            char ch = number.charAt(i);

            // 1. 스택 빈게 아닐때
            // 2. 스택의 최상단 숫자가 지금 숫자보다 작을때
            // 3. 아직 삭제해야할 숫자가 남아있을 때
            while (!stack.isEmpty() && (stack.peek() < ch) && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        // 남아있는 숫자 (스택에 존재하는) 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 역순으로 저장 (위치가 동일해야 하므로)
        for (int i = answerLength - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String number = "1234";
        String number2 = "4321";
        int k =2;

        String answer1 = solution.solution(number,2);
        String answer2 = solution.solution(number2,2);
        System.out.println(answer1);
        System.out.println(answer2);
    }
}
