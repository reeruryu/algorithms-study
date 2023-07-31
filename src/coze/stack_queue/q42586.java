package coze.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class q42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int deploy = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int cnt = 1;

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < progresses.length; i++) {
            if (deploy >= (int) Math.ceil((100.0 - progresses[i]) / speeds[i])) {
                cnt++;
            } else {
                result.add(cnt);
                deploy = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
                cnt = 1;
            }
        }
        result.add(cnt);

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
