package dmdwn99.week2;
import java.util.*;
public class P42897 {
    public int solution(int[] money) {
        int answer = 0;
        int[] x = Arrays.copyOf(money, money.length);
        int[] y = Arrays.copyOf(money, money.length);

        x[0] = 0;
        y[money.length-1] = 0;

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        dp1[0] = x[0];
        dp1[1] = x[1];
        dp2[0] = y[0];
        dp2[1] = y[1];

        for (int i=2;i<money.length;i++) {
            dp1[i] = Math.max(dp1[i-1], x[i]+dp1[i-2]);
            dp2[i] = Math.max(dp2[i-1], y[i]+dp2[i-2]);
        }

        return Math.max(dp1[money.length-1],dp2[money.length-1]);

    }
}
