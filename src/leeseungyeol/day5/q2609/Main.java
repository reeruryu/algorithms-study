package leeseungyeol.day5.q2609;

import java.util.*;
public class Main {

    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return GCD(b,a%b);
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();

        int gcd = GCD(p,q);
        System.out.println(gcd);
        System.out.println(p*q/gcd);

    }

}