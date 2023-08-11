package leeseungyeol.day4.q10870;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if(N == 0){
            System.out.println(0);
            return;
        }
        if(N == 1){
            System.out.println(1);
            return;
        }

        int a = 0;
        int b = 1;
        int cnt = 2;


        while(cnt != N){
            int tmp = a+b;
            a = b;
            b = tmp;
            cnt++;
        }
        System.out.println(a+b);

    }

}