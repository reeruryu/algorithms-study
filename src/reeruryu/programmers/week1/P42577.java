package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - 전화번호 목록 / 난이도: Level 2
정확성  테스트
    테스트 1 〉	통과 (0.06ms, 78.6MB)
    테스트 2 〉	통과 (0.06ms, 68.8MB)
    테스트 3 〉	통과 (0.04ms, 73.5MB)
    테스트 4 〉	통과 (0.05ms, 70.8MB)
    테스트 5 〉	통과 (0.06ms, 83.5MB)
    테스트 6 〉	통과 (0.03ms, 74.9MB)
    테스트 7 〉	통과 (0.04ms, 73.6MB)
    테스트 8 〉	통과 (0.05ms, 73.6MB)
    테스트 9 〉	통과 (0.05ms, 88.3MB)
    테스트 10 〉	통과 (0.06ms, 80.9MB)
    테스트 11 〉	통과 (0.05ms, 77.2MB)
    테스트 12 〉	통과 (0.04ms, 77.1MB)
    테스트 13 〉	통과 (0.05ms, 72.1MB)
    테스트 14 〉	통과 (1.54ms, 76MB)
    테스트 15 〉	통과 (3.13ms, 79.9MB)
    테스트 16 〉	통과 (4.64ms, 85.2MB)
    테스트 17 〉	통과 (5.37ms, 74.1MB)
    테스트 18 〉	통과 (8.80ms, 80.3MB)
    테스트 19 〉	통과 (4.18ms, 79.3MB)
    테스트 20 〉	통과 (5.82ms, 81.5MB)
효율성  테스트
    테스트 1 〉	통과 (3.03ms, 56.4MB)
    테스트 2 〉	통과 (5.22ms, 57.3MB)
    테스트 3 〉	통과 (302.15ms, 214MB)
    테스트 4 〉	통과 (229.11ms, 130MB)
 */

import java.util.HashSet;
import java.util.Set;

public class P42577 {
    public boolean solution(String[] phoneBook) {

        Set<String> set = new HashSet<>();

        for (String phone: phoneBook) {
            set.add(phone);
        }

        for (String phone: phoneBook) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
