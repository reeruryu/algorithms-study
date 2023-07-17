package leeseungyeol.day2.q42839;

import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        // 1. 순열집합과, 숫자 리스트 생성.
        HashSet<Integer> perm = new HashSet<>(); // 중복을 제거하기 위해서 HashSet 으로.
        ArrayList<Integer> numList = new ArrayList<>();

        // 2. String -> 숫자 리스트.
        for (int i = 0; i < numbers.length(); i++) {
            numList.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
        }

        System.out.println(numList);
        System.out.println("=================");

        // 3. 숫자 사용 여부 체크.
        boolean[] visited = new boolean[numList.size()];

        // 4. 순열 생성. ( 사용가능한 숫자들 생성 )
        generatePermutations(numList, visited, new StringBuilder(), perm);

        // 5. 소수 판별.
        for (int num : perm) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 순열 생성 메서드 (조합 생성 메서드도 나올 수 있으니 체크할것)
    private void generatePermutations(ArrayList<Integer> numList, boolean[] visited, StringBuilder current, HashSet<Integer> perm) {
        // 1. 종료조건
        if (current.length() > 0) {
            perm.add(Integer.parseInt(current.toString()));
        }

        // 2. 재귀를 통해서 가능한 모든 순열 조합을 제시.
        for (int i = 0; i < numList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(numList.get(i));
                generatePermutations(numList, visited, current, perm);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 소수임을 판별하는 메서드
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String numbers = "17";
        int result = solution.solution(numbers);
        System.out.println(result);  // 3

    }
}
