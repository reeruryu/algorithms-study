package dmdwn99.programmers.hash;
import java.util.*;
public class P1845 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(Integer num : nums) hashMap.put(num, 1);
            if (hashMap.size() > nums.length / 2)
                return nums.length / 2;
            return hashMap.size();
        }
    }
}
