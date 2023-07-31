package dmdwn99.week1;
import java.util.*;
public class P42746 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(array, (s1, s2) -> Integer.valueOf(s2+s1).intValue() - Integer.valueOf(s1+s2).intValue());

        for (String s : array)
            answer += s;
        if (answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}
