package coze.hash;

import java.util.Arrays;
import java.util.Objects;

public class q42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(completion);
        Arrays.sort(participant);
        int idx = 0;
        if (participant.length == 1) {
            answer = participant[0];
        } else {
            for (String p : participant) {
                if (!Objects.equals(p, completion[idx])) {
                    answer = p;
                    break;
                }
                idx++;
                if (completion.length == idx) {
                    answer = participant[participant.length - 1];
                    break;
                }
            }
        }
        return answer;
    }

}
