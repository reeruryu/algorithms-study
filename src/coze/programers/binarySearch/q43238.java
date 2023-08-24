package coze.programers.binarySearch;

import java.util.Arrays;

public class q43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long right = (long) times[times.length - 1] * n;
        long mid = 0;
        long left = 1;
        long sum = 0;
        long answer = 0;

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
