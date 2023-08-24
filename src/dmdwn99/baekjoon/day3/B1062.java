package dmdwn99.baekjoon.day3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
문제: 백준 - 가르침 / 골드4
 */
public class B1062 {
    public static int n, k;
    public static int answer = Integer.MIN_VALUE;
    public static boolean[] v;
    public static String[] word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];

        for (int i=0;i<n;i++) {
            String str = br.readLine();
            str = str.substring(4, str.length()-4); // 시간 초과로 문자열 길이 줄임
            word[i] = str;
        }
        if (k < 5) {
            System.out.println(0);
            return;
        }
        else if (k == 26) {
            System.out.println(n);
            return;
        }
        v = new boolean[26];
        v['a'-'a'] = true;
        v['c'-'a'] = true;
        v['i'-'a'] = true;
        v['n'-'a'] = true;
        v['t'-'a'] = true;

        backtracking(0, 0);
        System.out.println(answer);
    }
    public static void backtracking(int start, int len) {
        if (len == k-5) {
            int cnt = 0;
            for (int i=0;i<n;i++) {
                boolean flag = true;
                for (int j=0;j<word[i].length();j++) {
                    if (!v[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i=start;i < 26; i++) {
            if (v[i] == false) {
                v[i] = true;
                backtracking(i+1, len + 1);
                v[i] = false;
            }
        }
    }
}
