package coze.programers.brute_force;

public class q87946 {
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        dfs(0, k, dungeons, visited);
        return answer;
    }

    public void dfs(int count, int k, int[][] dungeons, int[] visited){
        for (int i = 0; i < dungeons.length; i++){
            if (visited[i] == 0 && k >= dungeons[i][0]){
                visited[i] = 1;
                dfs(count+1, k - dungeons[i][1], dungeons, visited);
                visited[i] = 0;
            }
        }
        if (answer < count){
            answer = count;
        }
    }
}
