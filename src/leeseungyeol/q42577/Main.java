package leeseungyeol.q42577;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 전화번호부를 HashMap에 추가
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 전화번호 체크
        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++) {
                // 접두어인 경우, false 반환
                if (map.containsKey(number.substring(0, i))) {
                    return false;
                }
            }
        }

        // 접두어가 없는 경우, true 반환
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result = solution.solution(phone_book);
        System.out.println(result);  // false

        phone_book = new String[]{"123", "456", "789"};
        result = solution.solution(phone_book);
        System.out.println(result);  // true

        phone_book = new String[]{"12", "123", "1235", "567", "88"};
        result = solution.solution(phone_book);
        System.out.println(result);  // false
    }
}