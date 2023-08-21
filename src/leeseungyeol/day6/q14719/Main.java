package leeseungyeol.day6.q14719;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int q = scanner.nextInt();
        ArrayList<Integer> height = new ArrayList<>();
        int result = 0;


        for (int i = 0; i < q; i++) {
            height.add(scanner.nextInt());
        }

        for (int i = 1; i < height.size() - 1; i++) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height.get(j));
            }

            int rightMax = 0;
            for (int j = i + 1; j < height.size(); j++) {
                rightMax = Math.max(rightMax, height.get(j));
            }

            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height.get(i)) {
                result += minHeight - height.get(i);
            }
        }

        System.out.println(result);
    }


}

