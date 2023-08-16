package dmdwn99.programmers.dfs_bfs;
import java.util.*;
public class P43162 {
    public static boolean[] v;
    public static int answer = 0;
    public static Queue<Integer> queue;
    public int solution(int n, int[][] computers) {
        v = new boolean[computers.length];
        queue = new LinkedList<>();
        for (int i=0;i<n;i++){
            if (!v[i]) {
                queue.add(i);
                bfs(n, computers);
            }
        }
        return answer;
    }
    public void bfs(int n, int[][] computers) {
        if (queue.isEmpty()) {
            answer++;
            return;
        }
        int now = queue.poll();
        v[now] = true;
        for (int i=0;i<n;i++) {
            if (i == now)
                continue;
            if (!v[i] && computers[now][i] == 1) {
                queue.add(i);
            }
        }
        bfs(n, computers);
    }
}
