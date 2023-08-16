package reeruryu.programmers.week2;

/*
문제: 프로그래머스 - 아이템 줍기 / 난이도: Level 3
 */

public class P87694 {
    static final int[] moveX = new int[]{1, -1, 0, 0},
            moveY = new int[]{0, 0, 1, -1};
    static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        return answer;
    }
}
