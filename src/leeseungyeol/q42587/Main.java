package leeseungyeol.q42587;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sumWeight = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i: truck_weights){
            while(true){
                if(queue.isEmpty()){
                    queue.add(i);
                    sumWeight += i;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sumWeight = sumWeight - queue.poll();
                }
                else{
                    if(sumWeight+i > weight){
                        queue.add(0);
                        answer++;
                    }
                    else{
                        queue.add(i);
                        sumWeight += i;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer+ bridge_length;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int result = solution.solution(bridge_length, weight, truck_weights);
        System.out.println(result);  // 8
    }
}