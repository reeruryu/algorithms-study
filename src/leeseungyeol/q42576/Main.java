package leeseungyeol.q42576;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] p1 = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] c1 = new String[]{"stanko", "ana", "mislav"};

        String answer2 = sol.solution(p1, c1);
        System.out.println(answer2);

    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String player: participant)
        {
            map.put(player,map.getOrDefault(player,0)+1);
        }
//        System.out.println("map = " + map);
        
        for(String complete: completion)
        {
            map.put(complete,map.get(complete)-1);
        }

//        System.out.println("map = " + map);

        for(String key: map.keySet())
        {
            if(map.get(key) == 1)
            {
                answer+= key;
            }
        }

        return answer;
    }
}