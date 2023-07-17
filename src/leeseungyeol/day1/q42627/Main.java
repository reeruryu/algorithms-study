package leeseungyeol.day1.q42627;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int now = 0;
        int rst = 0;
        int n = jobs.length;

        while (jobs.length > 0) {
            ArrayList<int[]> waitList = new ArrayList<>();
            ArrayList<int[]> restList = new ArrayList<>();

            for (int[] job : jobs) {
                if (job[0] <= now) {
                    waitList.add(job);
                } else {
                    restList.add(job);
                }
            }

            waitList.sort((a, b) -> a[1] - b[1]);

            if (!waitList.isEmpty()) {
                int[] wait = waitList.remove(0);
                now += wait[1];
                rst += (now - wait[0]);
            } else {
                now++;
            }

            jobs = new int[waitList.size() + restList.size()][];
            int index = 0;
            for (int[] job : waitList) {
                jobs[index] = job;
                index++;
            }
            for (int[] job : restList) {
                jobs[index] = job;
                index++;
            }
        }

        return rst / n;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int result = solution.solution(jobs);
        System.out.println(result);  // 9
    }
}