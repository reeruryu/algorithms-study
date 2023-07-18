package dmdwn99.week2;
import java.util.*;
public class P42895 {
    public int solution(int N, int number) {
        int answer = 0;
        Set<Integer>[] set = new Set[9];

        int num = 0;

        for (int i=1;i<=8;i++) {
            num = num*10+N;
            set[i] = new HashSet<>();
            set[i].add(num);
        }

        if (N==number)
            return 1;

        for (int i=2;i<9;i++) {
            for (int j=1;j<i;j++) {
                for (Integer x : set[j]) {
                    for (Integer y : set[i-j]) {
                        set[i].add(x+y);
                        set[i].add(x-y);
                        set[i].add(x*y);
                        if (x!=0)
                            set[i].add(y/x);
                        if (y!=0)
                            set[i].add(x/y);
                    }
                }
            }
            if (set[i].contains(number))
                return i;
        }
        return -1;
    }
}
