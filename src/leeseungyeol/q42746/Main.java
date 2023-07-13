package leeseungyeol.q42746;

import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        return answer;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution.solution(genres,plays);
        System.out.println(Arrays.toString(result));
    }
}