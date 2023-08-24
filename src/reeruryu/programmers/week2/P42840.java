package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 모의고사 / 난이도: Level 1
 */

import java.util.*;

public class P42840 {
    public int[] solution(int[] answers) {

        List<Integer> res = new ArrayList<>();

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == person1[i % (person1.length)]) cnt[0]++;
            if (answer == person2[i % (person2.length)]) cnt[1]++;
            if (answer == person3[i % (person3.length)]) cnt[2]++;

        }

        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < cnt.length; i++) {
            if (max == cnt[i]) res.add(i + 1);
        }

        return res.stream().mapToInt(x -> x).toArray();
    }

}
