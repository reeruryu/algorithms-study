package dmdwn99.week2;
import java.util.*;
public class P87946 {
    public static boolean[] v;
    public static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    public void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        for (int i=0;i<dungeons.length;i++) {
            if (v[i] == false && dungeons[i][0] <= k) {
                v[i] = true;
                dfs(k - dungeons[i][1], dungeons, count+1);
                v[i] = false;
            }
        }
    }
}
