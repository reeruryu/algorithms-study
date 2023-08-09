package leeseungyeol.day3.q42885;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {

        // 1. 정렬
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        // 2. 제일 무거운사람 먼저 보내되, 가벼운 사람 있으면 넣어주기 (그리디, 지금 할 수있는 최선)
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] people = {70,50,80,50};
        int limit = 100;
        int answer = solution.solution(people,limit);
        System.out.println(answer);
    }
}
