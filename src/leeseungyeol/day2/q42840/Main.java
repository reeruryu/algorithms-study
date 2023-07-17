package leeseungyeol.day2.q42840;
import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[]{0, 0, 0};
        int[] score = new int[]{0, 0, 0};
        ArrayList <Integer> list = new ArrayList<>();
        for(int k:answers)
        {
            if(k == a[count[0]++])
            {
                score[0]++;
            }
            if(k == b[count[1]++])
            {
                score[1]++;
            }
            if(k == c[count[2]++])
            {
                score[2]++;
            }
            if(count[0] >= a.length){
                count[0] = 0;
            }
            if(count[1] >= b.length){
                count[1] = 0;
            }

            if(count[2] >= c.length){
                count[2] = 0;
            }
        }
        System.out.println("score = " + Arrays.toString(score));
        System.out.println("count = " + Arrays.toString((score)));

        int max = Math.max (Math.max(score[0],score[1]),score[2]);
        for (int i = 0; i < 3; i++) {
            if(max == score[i])
            {
                list.add(i+1);
            }
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] answers = {1,2,3,4,5};
        ArrayList<Integer> result = solution.solution(answers);
        System.out.println(result);  // [1]

    }
}
