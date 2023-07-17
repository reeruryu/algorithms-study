package leeseungyeol.day2.q43105;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


class Solution {

    public int solution(int[][] triangle) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < (triangle.length); i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(triangle[0][0]);

//        System.out.println(dp);

        for (int i = 1; i < triangle.length; i++) {

            dp.get(i).add(dp.get(i - 1).get(0) + triangle[i][0]);

            for (int j = 1; j < i; j++) {
                dp.get(i).add(Math.max(dp.get(i - 1).get(j - 1) + (triangle[i][j]),dp.get(i - 1).get(j) + (triangle[i][j])));
            }

            dp.get(i).add(dp.get(i - 1).get(i - 1) + triangle[i][i]);

//            System.out.println(dp);
        }

        dp.get(triangle.length-1).sort(Collections.reverseOrder());

        return dp.get(triangle.length-1).get(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 입력
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        // 결과 출력
        int answer = solution.solution(triangle);
        System.out.println(answer);
    }
}
