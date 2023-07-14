package coze;

import java.util.LinkedList;
import java.util.Queue;

public class q42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + truck > weight) {
                        q.add(0);
                        answer++;
                    } else {
                        q.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

}
