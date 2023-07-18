package dmdwn99.week2;
import java.util.*;
public class P84512 {
    public int answer = 0;
    public static int cnt = 0;
    public static Stack<String> stack;
    public int solution(String word) {
        String[] vowel = {"A", "E", "I", "O", "U"};
        stack = new Stack<>();
        for (int i=0;i<5;i++){
            dfs(vowel, word, vowel[i]);
        }
        return answer;
    }
    public void dfs(String[] vowel, String word, String now) {
        if (now.length() == 6)
            return;
        cnt++;
        if (word.equals(now))
            answer = cnt;
        stack.push(now);

        for (int i=0;i<5;i++) {
            dfs(vowel, word, now+vowel[i]);
        }
        stack.pop();
    }
}
