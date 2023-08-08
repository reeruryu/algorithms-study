package dmdwn99.week3;
import java.util.*;
public class P42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        Arrays.sort(people);

        for (int i=right;i>=left;i--) {
            if (people[i] + people[left] > limit)
                answer++;
            else {
                left++;
                answer++;
            }
        }

        return answer;
    }
}
