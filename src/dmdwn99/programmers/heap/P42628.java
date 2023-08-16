package dmdwn99.programmers.heap;
import java.util.*;
public class P42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> up_pq = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> do_pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        boolean status = true; // true면 up_pq에 값 저장

        for (String str : operations){
            if (str.charAt(0) == 'I') {
                Integer num = Integer.valueOf(str.substring(2));
                if (status) up_pq.add(num);
                else do_pq.add(num);
            } else if (str.equals("D 1")) {
                if (up_pq.size() == 0 && do_pq.size() == 0) continue;
                else {
                    if (status) {
                        do_pq.clear();
                        while (up_pq.size() != 0)
                            do_pq.add(up_pq.poll());
                        status = false;
                    }
                    do_pq.poll();
                }
            } else if (str.equals("D -1")) {
                if (up_pq.size() == 0 && do_pq.size() == 0) continue;
                else {
                    if (!status) {
                        up_pq.clear();
                        while (do_pq.size() != 0){
                            up_pq.add(do_pq.poll());
                        }
                        status = true;
                    }
                    up_pq.poll();
                }
            }
        }
        if (up_pq.size() == 0 && do_pq.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        if (status) {
            answer[1] = up_pq.poll().intValue();
            while (up_pq.size() > 1){
                up_pq.poll();
            }
            answer[0] = up_pq.poll().intValue();
        } else {
            answer[0] = do_pq.poll().intValue();
            while (do_pq.size() > 1){
                do_pq.poll();
            }
            answer[1] = do_pq.poll().intValue();
        }

        return answer;
    }

}
