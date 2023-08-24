package coze.programers.greedy;

public class q42883 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char max;
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j < k + i; j++) {
                if (max < number.charAt(j)){
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
