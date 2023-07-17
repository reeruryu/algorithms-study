package reeruryu.week2;

/*
문제: 프로그래머스 - 도둑질 / 난이도: Level 4
 */

public class P42897 {
    public int solution(int[] money) {
        int answer = 0;
        if (money.length == 3) {
            for (int i = 0; i < 3; i++) {
                answer = Math.max(answer, money[i]);
            }
            return answer;
        }

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        // 첫 집 무조건 터는 경우
        dp1[0] = money[0];
        dp1[1] = money[0];

        // 첫 집 무조건 털지 않는 경우
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            answer = Math.max(answer, dp2[i]);

            if (i == money.length - 1) break;
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            answer = Math.max(answer, dp1[i]);
        }

        return answer;
    }

}
