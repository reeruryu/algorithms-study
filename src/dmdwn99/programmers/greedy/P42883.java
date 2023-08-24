package dmdwn99.programmers.greedy;

public class P42883 {
    public String solution(String number, int k) {
        String answer = "";
        int idx = 0, point = 0;

        for (int i=0;i< number.length()-k;i++) {
            char max = '0';
            for (int j=idx; j <=i+k;j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    point = j;
                }
                if (max == '9')
                    break;
            }
            answer += max;
            idx = point + 1;
        }

        return answer;
    }
}
