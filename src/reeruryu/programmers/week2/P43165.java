package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 타겟 넘버 / 난이도: Level 2
 */

public class P43165 {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, target, 0);

        return cnt;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) cnt++;
            return;
        }

        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);

    }
}
