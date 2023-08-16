package dmdwn99.programmers.stack_queue;
import java.util.*;
public class P42584 {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<prices.length-1;i++){
            queue.add(prices[i]);
            for (int j=i+1;j<prices.length;j++){
                queue.add(prices[j]);
                if (queue.peek()>prices[j]) break;
            }
            answer.add(queue.size()-1);
            queue.clear();
        }
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
