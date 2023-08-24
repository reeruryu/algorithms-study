package dmdwn99.baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제: 백준 - 부분 문자열 / 브론즈2
 */
public class B16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        int n = p.length();
        int[] table = new int[n];

        // 접두사, 접미사 찾기
        int idx = 0;
        for (int i = 1; i < n; i++) {
            // idx > 0 -> 일치하는 문자가 발생했을 떼
            // 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려줌
            while (idx > 0 && p.charAt(i) != p.charAt(idx))
                idx = table[idx - 1];
            if (p.charAt(i) == p.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        idx = 0;
        for (int i=0;i<s.length();i++) {
            while (idx > 0 && s.charAt(i) != p.charAt(idx))
                idx = table[idx-1];

            if (s.charAt(i) == p.charAt(idx)) {
                if (idx == p.length()-1) {
                    System.out.println(1);
                    return;
                }
                else
                    idx++;
            }
        }
        System.out.println(0);
    }
}
// Java의 contains 메서드는 공간 복잡도 때문에 KMP 알고리즘을 적용하지 않음
