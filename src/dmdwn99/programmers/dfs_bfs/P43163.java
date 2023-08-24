package dmdwn99.programmers.dfs_bfs;
import java.util.*;
public class P43163 {
    int answer;
    boolean[] v;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        v = new boolean[words.length];
        bfs(begin, target, words);
        return answer;
    }
    class Word {
        String word;
        int count;

        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    public void bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while (!q.isEmpty()) {
            Word now = q.poll();

            if (now.word.equals(target)) {
                answer = now.count;
                return;
            }

            for (int i=0;i<words.length;i++) {
                int check = 0;
                for (int j=0;j<begin.length();j++) {
                    if (now.word.charAt(j) == words[i].charAt(j))
                        check++;
                }
                if (!v[i] && check == begin.length()-1) {
                    q.add(new Word(words[i], now.count+1));
                    v[i] = true;
                }
            }
        }
    }
}
