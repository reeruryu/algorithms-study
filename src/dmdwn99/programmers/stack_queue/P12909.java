package dmdwn99.programmers.stack_queue;
import java.util.*;
public class P12909 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '(') stack.push('(');
            else if (!stack.empty() && s.charAt(i) == ')') stack.pop();
            else if (stack.empty() && s.charAt(i) == ')') return false;
        }

        return stack.size()==0;
    }
}
