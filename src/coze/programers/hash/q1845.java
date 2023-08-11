package coze.programers.hash;

import java.util.HashSet;
import java.util.Set;

public class q1845 {
    public int solution(int[] nums) {
        int pickCount = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(pickCount, set.size());
    }

}
