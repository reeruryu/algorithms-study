package dmdwn99.programmers.brute_force;
import java.util.*;
public class P42840 {
    public int[] solution(int[] answers) {
        int max = 0;
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == i%5+1)
                score[0]++;
            if (answers[i] == second[i%8])
                score[1]++;
            if (answers[i] == third[i%10])
                score[2]++;
        }
        max = score[0];
        if (max < score[1])
            max = score[1];
        if (max < score[2])
            max = score[2];

        for (int i = 0;i < 3; i++) {
            if (max == score[i])
                answer.add(i+1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
