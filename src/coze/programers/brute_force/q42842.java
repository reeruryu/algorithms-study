package coze.programers.brute_force;

public class q42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        // 가로 세로 길이가 모두 3이상 이어야함.
        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                // 가로 길이는 세로 길이와 같거나 길다. 따라서, col = max , row = min
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                // yellow의 개수
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
