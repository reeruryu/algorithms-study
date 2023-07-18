package dmdwn99.week2;
import java.util.*;
public class P42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int height = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=1;i<=brown+yellow;i++){
            if ((brown+yellow)%i == 0)
                list1.add(i);
            if (yellow%i == 0)
                list2.add(i);
        }
        for (Integer num : list1) {
            if (list2.contains((brown+yellow) / num - 2) && list2.contains(num - 2)) {
                height = num;
                break;
            }
        }
        answer[0] = (brown+yellow) / height;
        answer[1] = height;
        return answer;
    }
}
