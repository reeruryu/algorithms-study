package dmdwn99.programmers.dfs_bfs;
import java.util.*;
public class P43164 {
    boolean[] v;
    static List<String> list;
    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public void dfs(String start, String end, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            list.add(end);
            return;
        }
        for (int i=0;i< tickets.length;i++) {
            if (tickets[i][0].equals(start) && !v[i]) {
                v[i] = true;
                dfs(tickets[i][1], end + " " + tickets[i][1], tickets, cnt+1);
                v[i] = false;
            }
        }
    }
}
