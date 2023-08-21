package reeruryu.baekjoon.day3;

/*
문제: 백준 - 부분 문자열
어려워..
https://www.acmicpc.net/problem/16916
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        boolean flag = false;
        for (int i = 0; i <= S.length() - P.length(); i++) {
            if (S.substring(i, i + P.length()).equals(P)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }
}
