package reeruryu;

/*
문제: 프로그래머스 - 폰켓몬 / 난이도: Level 1
정확성  테스트
    테스트 1 〉	통과 (0.06ms, 78MB)
    테스트 2 〉	통과 (0.12ms, 77.1MB)
    테스트 3 〉	통과 (0.06ms, 73.1MB)
    테스트 4 〉	통과 (0.06ms, 71MB)
    테스트 5 〉	통과 (0.12ms, 72.1MB)
    테스트 6 〉	통과 (0.06ms, 75.9MB)
    테스트 7 〉	통과 (0.27ms, 73.1MB)
    테스트 8 〉	통과 (0.25ms, 71.8MB)
    테스트 9 〉	통과 (0.27ms, 72.2MB)
    테스트 10 〉	통과 (0.28ms, 76.9MB)
    테스트 11 〉	통과 (0.14ms, 75.5MB)
    테스트 12 〉	통과 (0.32ms, 76.8MB)
    테스트 13 〉	통과 (1.37ms, 87.2MB)
    테스트 14 〉	통과 (0.49ms, 78.8MB)
    테스트 15 〉	통과 (0.62ms, 76.6MB)
    테스트 16 〉	통과 (5.64ms, 85MB)
    테스트 17 〉	통과 (2.90ms, 80.1MB)
    테스트 18 〉	통과 (3.43ms, 79.9MB)
    테스트 19 〉	통과 (4.35ms, 76.4MB)
    테스트 20 〉	통과 (2.85ms, 78.4MB)
 */

import java.util.HashSet;
import java.util.Set;

public class P1845 {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        return Math.min(set.size(), max);
    }
}
