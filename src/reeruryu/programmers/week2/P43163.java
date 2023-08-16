package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 단어 변환 / 난이도: Level 3
 */

import java.util.*;

public class P43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>(List.of(words));
        if (!set.contains(target)) return 0;

        for (int i = 0; i < words.length; i++) {
            if (isChangable(begin, words[i])) {
                int res = bfs(words, i, begin, target);
                if (res != 0) {
                    answer = Math.min(answer, res);
                }
            }
        }

        return answer == Integer.MAX_VALUE? 0 : answer;
    }

    public int bfs(String[] words, int i, String begin, String target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] cnt = new int[words.length];

        queue.offer(i);
        cnt[i] = 1;

        while (!queue.isEmpty()) {
            int w = queue.poll();

            if (words[w].equals(target)) {
                return cnt[w];
            }

            for (int j = 0; j < words.length; j++) {
                if (cnt[j] > 0) continue;
                if (!isChangable(words[w], words[j])) continue;
                else {
                    queue.offer(j);
                    cnt[j] = cnt[w] + 1;
                }
            }
        }

        return 0;
    }

    public boolean isChangable(String w1, String w2) {
        int cnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                cnt++;
            }

            if (cnt > 1) return false;
        }

        return true;
    }
}
