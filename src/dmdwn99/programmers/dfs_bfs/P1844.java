package dmdwn99.programmers.dfs_bfs;
import java.util.*;
public class P1844 {
    boolean[][] v;
    int answer;
    public int solution(int[][] maps) {
        answer = -1;
        v = new boolean[maps.length][maps[0].length];
        bfs(maps);
        return answer;
    }
    public class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0,0,1));
        v[0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == maps.length-1 && p.y == maps[0].length-1) {
                answer = p.count;
                return;
            }

            for (int i = 0; i<dx.length;i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny, p.count+1));
                }
            }
        }
    }
}
