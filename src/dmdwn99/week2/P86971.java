package dmdwn99.week2;
import java.util.*;
public class P86971 {
    public static int[][] graph;
    public static int answer = -1;
    public int solution(int n, int[][] wires) {
        answer = n;
        graph = new int[n+1][n+1];
        for (int i=0;i<wires.length;i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int i=0;i<wires.length;i++){
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(n, from));
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        return answer;
    }
    public static int bfs(int n, int x) {
        boolean[] v = new boolean[n+1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        v[x] = true;

        q.add(x);

        while(!q.isEmpty()){
            int tmp = q.poll();

            for (int i=1;i<=n;i++){
                if (graph[tmp][i]==1 && !v[i]) {
                    v[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(cnt - (n-cnt));
    }
}
