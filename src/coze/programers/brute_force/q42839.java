package coze.programers.brute_force;

import java.util.HashSet;
import java.util.Set;

public class q42839 {
    Set<Integer> primeSet;
    public int solution(String numbers) {
        int answer = 0;
        primeSet = new HashSet<>();

        recursive(numbers, "");

        answer = primeSet.size();
        return answer;
    }

    public void recursive(String input, String prefix) {

        // 소수일 경우 Set에 추가
        if(!prefix.equals("")) {
            checkPrime(prefix);
        }
        int len = input.length();

        // 이 재귀 메서드 설명해주실 분 ...
        for(int i = 0; i < len; i++) {
            recursive(input.substring(0, i) + input.substring(i + 1, len), prefix + input.charAt(i));
        }
    }

    public void checkPrime(String num){
        int numToInt = Integer.parseInt(num);
        int limit = (int) Math.sqrt(numToInt);

        if (numToInt == 2){
            primeSet.add(numToInt);
            return;
        }
        if (numToInt < 2 || numToInt%2 == 0){
            return;
        }

        for (int i = 3; i < limit; i++){
            if (numToInt % i == 0){
                return;
            }
        }
        primeSet.add(numToInt);
    }
}
