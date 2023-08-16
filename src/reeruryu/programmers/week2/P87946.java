package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 피로도 / 난이도: Level 2
 */

public class P87946 {
    public static boolean[] visited;
    public static int answer = 0;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        expire(dungeons, 0, k);

        return answer;
    }

    public void expire(int[][] dungeons, int cnt, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                expire(dungeons, cnt + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
