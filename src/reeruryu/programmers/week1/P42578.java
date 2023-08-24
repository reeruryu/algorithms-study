package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - 의상 / 난이도: Level 2
정확성  테스트
    테스트 1 〉	통과 (0.07ms, 83MB)
    테스트 2 〉	통과 (0.06ms, 71.5MB)
    테스트 3 〉	통과 (0.08ms, 75.5MB)
    테스트 4 〉	통과 (0.12ms, 71.5MB)
    테스트 5 〉	통과 (0.07ms, 88.6MB)
    테스트 6 〉	통과 (0.07ms, 64.2MB)
    테스트 7 〉	통과 (0.09ms, 77.2MB)
    테스트 8 〉	통과 (0.07ms, 67.3MB)
    테스트 9 〉	통과 (0.08ms, 71.8MB)
    테스트 10 〉	통과 (0.04ms, 78.5MB)
    테스트 11 〉	통과 (0.04ms, 75.9MB)
    테스트 12 〉	통과 (0.10ms, 75MB)
    테스트 13 〉	통과 (0.39ms, 83.1MB)
    테스트 14 〉	통과 (0.07ms, 65.8MB)
    테스트 15 〉	통과 (0.04ms, 71.4MB)
    테스트 16 〉	통과 (0.06ms, 69.9MB)
    테스트 17 〉	통과 (0.04ms, 71.3MB)
    테스트 18 〉	통과 (0.04ms, 72.4MB)
    테스트 19 〉	통과 (0.04ms, 72.7MB)
    테스트 20 〉	통과 (0.05ms, 65.6MB)
    테스트 21 〉	통과 (0.05ms, 76.2MB)
    테스트 22 〉	통과 (0.04ms, 73.8MB)
    테스트 23 〉	통과 (0.05ms, 75.5MB)
    테스트 24 〉	통과 (0.06ms, 72.1MB)
    테스트 25 〉	통과 (0.07ms, 76.8MB)
    테스트 26 〉	통과 (0.07ms, 83.9MB)
    테스트 27 〉	통과 (0.04ms, 69.3MB)
    테스트 28 〉	통과 (0.07ms, 77.6MB)
 */

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for (String[] c: clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        int res = 1;
        for (String k: map.keySet()) {
            res *= (map.get(k) + 1);
        }

        return res - 1;

    }
}
