package coze.programers.hash;

import java.util.HashMap;
import java.util.Map;

public class q42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 1);
            }
        }

        for (Map.Entry<String, Integer> entryMap : map.entrySet()) {
            answer *= entryMap.getValue() + 1;
        }
        return answer - 1;
    }

}
