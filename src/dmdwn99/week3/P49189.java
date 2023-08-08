package dmdwn99.week3;
import java.util.*;
public class P49189 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] d = new int[n + 1];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i=0;i<n+1;i++) {
            g.add(new ArrayList<>());
        }

        for (int[] x : edge) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }

        boolean[] v = new boolean[n+1];
        v[1] = true;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);

        while (bfs.size() != 0) {
            int now = bfs.poll();
            ArrayList<Integer> node = g.get(now);
            for (int i = 0; i < node.size(); i++) {
                if (!v[node.get(i)]) {
                    bfs.add(node.get(i));
                    v[node.get(i)] = true;
                    d[node.get(i)] = d[now] + 1;
                }
            }
        }

        Arrays.sort(d);
        int max = d[d.length-1];
        for (int i = d.length-1;d[i]==max;i--) {
            answer++;
        }
        return answer;
    }
}
