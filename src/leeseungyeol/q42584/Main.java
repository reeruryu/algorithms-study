package leeseungyeol.q42584;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt = 0;
        int index = 0;

        for (int i : prices) {
            for (int j = index + 1; j < prices.length; j++) {
                if (i <= prices[j]) {
                    cnt++;
                }
                else{
                    cnt++;
                    break;
                }
            }
            answer[index] = cnt;
            index++;
            cnt = 0;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();


        int[] prices = {5, 4, 3, 2, 5};
        int[] result = solution.solution(prices);
        System.out.println(Arrays.toString(result)); // [4,3,2,1,0]
    }
}