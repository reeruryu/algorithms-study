package coze;

import java.util.ArrayList;
import java.util.List;

public class q12906 {
    public static int[] solution(int[] arr) {
        List<Integer> arrList = new ArrayList<>();

        arrList.add(arr[0]);
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arrList.get(Integer.valueOf(idx))) {
                arrList.add(arr[i]);
                idx++;
            }
        }
        int[] answer = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            answer[i] = arrList.get(i);
        }
        return answer;
    }

}
