package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - 완주하지 못한 선수 / 난이도: Level 1
정확성  테스트
    테스트 1 〉	통과 (0.07ms, 72.3MB)
    테스트 2 〉	통과 (0.08ms, 73.3MB)
    테스트 3 〉	통과 (0.74ms, 76.8MB)
    테스트 4 〉	통과 (0.92ms, 76.6MB)
    테스트 5 〉	통과 (1.48ms, 77.6MB)
    테스트 6 〉	통과 (0.03ms, 71.2MB)
    테스트 7 〉	통과 (0.04ms, 76.4MB)
효율성  테스트
    테스트 1 〉	통과 (36.53ms, 83.1MB)
    테스트 2 〉	통과 (58.94ms, 89.8MB)
    테스트 3 〉	통과 (92.43ms, 94.8MB)
    테스트 4 〉	통과 (90.77ms, 96.7MB)
    테스트 5 〉	통과 (77.37ms, 96.8MB)
 */

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for (String p: participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c: completion) {
            if (map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c) - 1);
        }

        return map.keySet().iterator().next();
    }
}
