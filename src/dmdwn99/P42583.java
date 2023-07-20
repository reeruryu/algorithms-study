package dmdwn99;
import java.util.*;
public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    ++time;
                    sum += truck;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (weight >= sum + truck) {
                        queue.add(truck);
                        ++time;
                        sum += truck;
                        break;
                    } else {
                        queue.add(0);
                        ++time;
                    }
                }
            }

        }
        return time + bridge_length;
    }
}
