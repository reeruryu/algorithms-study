package dmdwn99.programmers.greedy;
import java.util.*;
public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0;i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -100;
                    break;
                }
            }
        }
        for (int i = 0;i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] == reserve[j] - 1) || (lost[i] == reserve[j] + 1)) {
                    reserve[j] = -1;
                    lost[i] = -100;
                    break;
                }
            }
        }
        for (int l : lost) {
            if (l > 0) answer--;
        }

        return answer;
    }
}
