package dmdwn99.week3;
import java.util.*;
public class P42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
        int idx = -30001;

        for (int i=0;i<routes.length;i++) {
            if (idx < routes[i][0]) {
                idx = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
