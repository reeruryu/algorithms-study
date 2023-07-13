package dmdwn99;
import java.util.*;
public class P12906 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for (int x : arr) {
            if (stack.empty()){
                stack.push(x);
                continue;
            }
            if (stack.peek() != x) stack.push(x);
        }
        answer = stack.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
