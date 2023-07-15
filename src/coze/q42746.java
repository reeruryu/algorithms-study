package coze;

import java.util.Arrays;
import java.util.Comparator;

public class q42746 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] number = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }
        Comparator<String> comparator = (s1, s2) -> (s2 + s1).compareTo(s1 + s2);
        Arrays.sort(number, comparator);

        for (String num : number) {
            answer.append(num);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer.toString();
    }
}
