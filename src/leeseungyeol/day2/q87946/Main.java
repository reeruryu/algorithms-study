package leeseungyeol.day2.q87946;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int k, int[][] dungeons) {

        // 1. 모든 가능한 던전인덱스 순열 리스트 생성
        List<List<Integer>> allDungeons = new ArrayList<>();

        // 2. 가능한 던전 인덱스 순열 리스트 구함
        generatePermutations(dungeons, new ArrayList<>(), allDungeons);

        // 3. 피로도를 계산해서 최대로 갈 수 있는 던전 체크
        List<Integer> possible = new ArrayList<>(); // 가능한 모든 던전 순서의 최대 갯수 리스트
        for (List<Integer> permutation : allDungeons) {
            int stamina = k;
            int cnt = 0;
            for (int dungeon : permutation) {
                if (stamina >= dungeons[dungeon][0]) {
                    stamina -= dungeons[dungeon][1];
                    cnt++;
                } else {
                    break;
                }
            }
            possible.add(cnt);
        }

        // 4. 갈 수 있는 최대 던전 구함.
        int answer = 0;
        for (int cnt : possible) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    // 가능한 모든 던전순열 체크
    private void generatePermutations(int[][] dungeons, List<Integer> permutation, List<List<Integer>> result) {

        // 1. 종료조건
        if (permutation.size() == dungeons.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        // 2.
        for (int i = 0; i < dungeons.length; i++) {
            if (!permutation.contains(i)) {
                permutation.add(i);
                generatePermutations(dungeons, permutation, result);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);  // 3
    }
}