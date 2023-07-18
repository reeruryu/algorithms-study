package dmdwn99.week1;
import java.util.*;

public class P42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] name : clothes)
            hashMap.put(name[1], hashMap.getOrDefault(name[1], 0)+1);
        for (String key : hashMap.keySet())
            answer *= (hashMap.get(key) + 1);

        return answer-1;
    }
}
