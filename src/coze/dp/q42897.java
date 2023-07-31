package coze.dp;

public class q42897 {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] first = new int[len];
        int[] second = new int[len];
        first[0] = money[0];
        first[1] = money[0];
        second[1] = money[1];

        for (int i = 2; i < len; i++){
            first[i] = Math.max(first[i - 1], money[i] + first[i - 2]);
            second[i] = Math.max(second[i - 1], money[i] + second[i - 2]);
        }
        return Math.max(first[len - 2], second[len - 1]);
    }
}
