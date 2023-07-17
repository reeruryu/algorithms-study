package reeruryu.week2;

/*
문제: 프로그래머스 - 최소직사각형 / 난이도: Level 1
 */

public class P86491 {

    public int solution(int[][] sizes) {

        int w = 0, h = 0;
        for (int[] size: sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            w = Math.max(w, max);
            h = Math.max(h, min);
        }

        return w * h;
    }

}
