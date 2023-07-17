package coze.hash;

import java.util.HashMap;
import java.util.Map;

public class q42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        for (String number : phone_book) {
            map.put(number, 0);
        }

        for (String number : phone_book) {
            for (int i = 0; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

}
