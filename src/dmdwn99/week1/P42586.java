package dmdwn99.week1;
import java.util.*;
public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        int cnt = 0;
        for(;idx<progresses.length;){
            for (int i = 0; i< progresses.length;i++) {
                progresses[i] += speeds[i];
            }
            for (int i = idx; i< progresses.length;i++) {
                if (progresses[idx] >= 100) {
                    cnt++;
                    idx++;
                } else break;
            }
            if (cnt!=0) {
                answer.add(cnt);
                cnt=0;
            }
        }
        int[] array = answer.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}
