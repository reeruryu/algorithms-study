package reeruryu;

/*
문제: 프로그래머스 - 같은 숫자는 싫어 / 난이도: Level 1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P12906 {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int x: arr) {
            if (stack.isEmpty() || stack.peek() != x) {
                stack.push(x);
                answer.add(x);
            }
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}
