package dmdwn99.programmers.dfs_bfs;
import java.util.*;

public class P43165 {
    public static Stack<Integer> stack;
    public static int cnt = 0;
    public static int check = 0;
    public static int x;
    public static int solution(int[] numbers, int target) {
        x = target;
        dfs(0, numbers, 0);
        return cnt;
    }
    public static void dfs(int sum, int[] numbers,int index) {
        System.out.print("sum = " + sum);
        System.out.print(" index = " + index);
        System.out.println(" check = " + check++);
        if (index == numbers.length) {
            if (sum == x)
                cnt++;
            return;
        }
        dfs(sum+numbers[index], numbers, index+1); //
        dfs(sum-numbers[index], numbers, index+1);
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{1,1,1,1,1}, 3);
    }
}
