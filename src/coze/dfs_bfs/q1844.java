package coze.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

class q1844 {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<Position> q =new LinkedList<>();
        int[][] count = new int[maps.length][maps[0].length];

        q.add(new Position(0,0));
        count[0][0] = 1;

        while(!q.isEmpty()){
            Position current = q.poll();
            int curCount = count[current.col][current.row];

            for (int i = 0; i < 4; i++){
                Position moveP = new Position(current.col + move[i][0], current.row + move[i][1]);

                if (moveP.col < 0 || moveP.row < 0) continue;
                if (moveP.col == maps.length || moveP.row == maps[0].length) continue;
                if (maps[moveP.col][moveP.row] == 0) continue;
                count[moveP.col][moveP.row] = curCount + 1;

                maps[moveP.col][moveP.row] = 0;
                q.add(moveP);
            }
        }

        answer = count[maps.length - 1][maps[0].length - 1];
        if (answer == 0){
            return -1;
        }
        return answer;
    }
}

class Position{
    int col;
    int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
