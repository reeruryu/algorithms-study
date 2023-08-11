package coze.baekjoon.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> divisorList = new ArrayList<>();

        for (int i = 1; i <= N; i++){
            if (N % i == 0) {
                divisorList.add(i);
            }
        }

        if (divisorList.size() < K) {
            System.out.println(0);
        } else if (K == 0) {
            System.out.println(1);
        } else {
            System.out.println(divisorList.get(K - 1));
        }
    }
}
