package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 모음사전 / 난이도: Level 2
 */

import java.util.*;

public class P84512 {
    public static ArrayList<String> list = new ArrayList<>();
    public static String alphabet = "AEIOU";

    public int solution(String word) {
        int answer = 0;

        for (int i = 1; i <= 5; i++) {
            dfs("", 0, i);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    public void dfs(String word, int depth, int end) {
        if (depth == end) {
            list.add(word);
            return;
        }

        for (int i = 0; i < alphabet.length(); i++) {
            dfs(word + alphabet.charAt(i), depth + 1, end);
        }
    }

}
