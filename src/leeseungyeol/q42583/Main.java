package leeseungyeol.q42583;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i: priorities){
            queue.add(i);
        }

        System.out.println(queue);
        System.out.println("-------------");

        while(!queue.isEmpty()) {
            int now = queue.poll();
            boolean max = true;

            for (int next : queue) {
                if (next > now) {
                    max = false;
                    break;
                }
            }

            if (max) {
                answer++;
                if (location == 0) {
                    break;
                }
            }
            else {
                queue.add(now);
            }

            if (location == 0) {
                location = queue.size() - 1;
            } else {
                location --;
            }

//            System.out.println(queue);
        }


        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int result = solution.solution(priorities, location);
//        System.out.println(result);  // 1

        priorities = new int[]{1, 1, 9, 1, 1, 1};
        location = 0;
        result = solution.solution(priorities, location);
        System.out.println(result);  // 5
    }
}

