package reeruryu.programmers.week1;

/*
문제: 프로그래머스 - 가장 큰 수 / 난이도: Level 2
 */

import java.util.Arrays;

public class P42746 {
    public String solution(int[] numbers) {

        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));

        if (arr[0].equals("0")) return "0";

        for (String s : arr) {
            answer.append(s);
        }

        return answer.toString();
    }
}
