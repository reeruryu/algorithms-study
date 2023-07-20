package coze.binarySearch;

import java.util.Arrays;

public class q43236 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        int left = 1;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (rmRockCnt(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public int rmRockCnt(int[] rocks, int mid, int distance){
        int before = 0;
        int cnt = 0;

        for (int i = 0; i < rocks.length; i++){
            if (rocks[i] - before < mid){
                cnt++;
                continue;
            }
            before = rocks[i];
        }
        if (distance - before < mid){
            cnt++;
        }
        return cnt;
    }
}
