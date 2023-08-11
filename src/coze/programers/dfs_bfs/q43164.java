package coze.programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;

public class q43164 {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public void dfs(int depth, String now, String path, String[][] tickets){
        if (depth == tickets.length){
            list.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++){
            if (!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
