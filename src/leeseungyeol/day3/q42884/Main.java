package leeseungyeol.day3.q42884;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        // 1. 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        // 2. 설치
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            // 카메라 설치
            if (start > camera) {
                answer++;
                camera = end;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13},{-5,-3}};
        int answer = solution.solution(routes);

        System.out.println(answer);
    }
}
