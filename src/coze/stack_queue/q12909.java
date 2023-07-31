package coze.stack_queue;

import java.util.ArrayDeque;

public class q12909 {
    boolean solution(String s) {
        char[] sArr = s.toCharArray();
        ArrayDeque<String> sStack = new ArrayDeque<>();

        for (char c : sArr) {
            if (c == ')') {
                if (!sStack.isEmpty() && sStack.peekLast().equals("(")) {
                    sStack.pollLast();
                    continue;
                } else return false;
            }
            sStack.offerLast(String.valueOf(c));
        }
        return sStack.isEmpty();
    }

}
