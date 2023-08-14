package dmdwn99.programmers.brute_force;

public class P86491 {
    public int solution(int[][] sizes) {
        int max = 0;
        int s_max = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (max < sizes[i][0])
                max = sizes[i][0];
            if (max < sizes[i][1])
                max = sizes[i][1];
        }
        for (int i = 0; i < sizes.length; i++) {
            int tmp = 0;
            if (sizes[i][0] < sizes[i][1])
                tmp = sizes[i][0];
            else
                tmp = sizes[i][1];
            if (tmp > s_max)
                s_max = tmp;
        }
        return max * s_max;
    }
}
