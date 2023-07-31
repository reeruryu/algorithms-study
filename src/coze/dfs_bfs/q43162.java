package coze.dfs_bfs;

public class q43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++){
                if (!visited[i]){
                    answer++;
                    dfs(i, visited,computers);
                }
            }
            return answer;
        }

        public void dfs(int i, boolean[] visited, int[][]computers){
            visited[i] = true;

            for (int j = 0; j < computers.length; j++){
                if (!visited[j] && computers[i][j] == 1){
                    dfs(j, visited, computers);
                }
            }
        }
    }
}
