package leeseungyeol.q42578;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        // HashMap 생성.
        HashMap<String, Integer> map = new HashMap<>();

        // Value 값에다가 옷종류 추가
        for (String[] productList : clothes) {
//            System.out.println(Arrays.toString(productList));
            if (map.getOrDefault(productList[1], 0) != 0) {
                map.put(productList[1], map.get(productList[1]) + 1);
            } else {
                map.put(productList[1], 1);
            }
//            System.out.println("====================");
        }

        for (String key : map.keySet()) {
            if(map.size() == 1){
                return map.get(key);
            }
            answer += (map.get(key) + 1);
        }
//        System.out.println(map);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution.solution(clothes);
//        System.out.println(result);  // false

        clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        result = solution.solution(clothes);
        System.out.println(result);  // false

    }
}