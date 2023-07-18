package dmdwn99.week1;
import java.util.*;
public class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[idx++] = arr[commands[i][2]-1];
        }
        return answer;
    }
}
