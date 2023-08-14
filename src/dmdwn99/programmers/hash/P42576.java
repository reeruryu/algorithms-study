package dmdwn99.programmers.hash;
import java.util.*;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> listP = new ArrayList<>(Arrays.asList(participant));
        List<String> listC = new ArrayList<>(Arrays.asList(completion));

        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0;i<listP.size();i++){
            if (map.containsKey(listP.get(i))){
                map.put(listP.get(i), map.get(listP.get(i))+1);
            } else {
                map.put(listP.get(i), 1);
            }
        }

        for (int i=0;i<listC.size();i++){
            map.put(listC.get(i), map.get(listC.get(i))-1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
