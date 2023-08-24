package coze.programers.brute_force;

public class q86491 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int garo =0;
        int sero =0;

        //가로길이에서 최대값과 세로길이 에서 최댓값을 구해줌.
        for (int[] size : sizes) {
            garo = Math.max(garo, Math.max(size[0], size[1]));
            sero = Math.max(sero, Math.min(size[0], size[1]));
        }

        answer = garo*sero;
        return answer;
    }
}
