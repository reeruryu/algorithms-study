package reeruryu.baekjoon.day3;

/*
문제: 백준 - 가르침
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class B1062 {
    static int cnt;
    static int N, K;
    static int max = Integer.MIN_VALUE;
    static String[] words;

    static boolean[] isRead = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
//            words[i].replace("anta", "");
//            words[i].replace("tica", "");
        }

        if (K < 5) {
            System.out.println("0");
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        isRead['a' - 'a'] = true;
        isRead['c' - 'a'] = true;
        isRead['i' - 'a'] = true;
        isRead['n' - 'a'] = true;
        isRead['t' - 'a'] = true;

        cnt = K - 5;

        dfs(0, 0);
        System.out.println(max);

    }

    public static void dfs(int start, int depth) {
        if (cnt == depth) {
            int ans = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (!isRead[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
            max = Math.max(max, ans);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!isRead[i]) {
                isRead[i] = true;
                dfs(i, depth + 1);
                isRead[i] = false;
            }
        }
    }
}
