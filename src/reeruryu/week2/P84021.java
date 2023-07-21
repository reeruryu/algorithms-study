package reeruryu.week2;

/*
문제: 프로그래머스 - 퍼즐 조각 채우기 / 난이도: Level 3
 */

import java.util.*;

public class P84021 {
    static int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int solution(int[][] game_board, int[][] table) {

        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        boolean[][] visitedTable = new boolean[table.length][table.length];

        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        // 조각 모으기
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {

                if (table[i][j] == 1 && !visitedTable[i][j]) {
                    bfs(i, j, visitedTable, table, 1, tableList);
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }

        // 조각 찾기
        return findBlock(boardList, tableList);

    }

    public int findBlock(List<List<int[]>> board, List<List<int[]>> table) {
        int size = 0;
        int tableLen = table.size(); // 5
        int boardLen = board.size(); // 6
        boolean[] visitedBoard = new boolean[boardLen];
        for (List<int[]> tablePoints : table) {
            for (int j = 0; j < boardLen; j++) {
                List<int[]> boardPoints = board.get(j);

                // 조각 돌려서 확인
                if (tablePoints.size() == boardPoints.size() && !visitedBoard[j]) {
                    if (isRotate(boardPoints, tablePoints)) {
                        size += tablePoints.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }

        }

        return size;
    }

    public boolean isRotate(List<int[]> board, List<int[]> table) {
        boolean isCollect = false;

        board.sort((x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });

        for (int i = 0; i < 4; i++) { // table 퍼즐 0, 90, 180, 270도 회전
            table.sort((x, y) -> {
                if (x[0] == y[0]) {
                    return x[1] - y[1];
                } else {
                    return x[0] - y[0];
                }
            });

            int nearZeroX = table.get(0)[0];
            int nearZeroY = table.get(0)[1];
            for (int[] t : table) {
                t[0] -= nearZeroX;
                t[1] -= nearZeroY;
            }


            boolean isCollectPoint = true;
            for (int j = 0; j < board.size(); j++) { // 좌표 비교
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]) {
                    isCollectPoint = false;
                    break;
                }
            }

            if (isCollectPoint) {
                isCollect = true;
                break;
            } else { // 90도 회전 : x, y -> y, -x
                for (int[] t : table) {
                    int temp = t[0];
                    t[0] = t[1];
                    t[1] = -temp;
                }
            }
        }
        return isCollect;

    }

    public void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph,
                    int blockOrEmpty, List<List<int[]>> list){

        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new int[]{currentX, currentY});
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int[] d: direct) {
                int nextX = xy[0] + d[0];
                int nextY = xy[1] + d[1];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length)
                    continue;

                if (!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    subList.add(new int[]{nextX - currentX, nextY - currentY});
                }
            }
        }
        list.add(subList);
    }
}
