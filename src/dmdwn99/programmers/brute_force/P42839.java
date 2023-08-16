package dmdwn99.programmers.brute_force;
import java.util.*;
public class P42839 {
    public int solution(String numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int[] num = new int[10];
        int cnt=0;
        boolean prime = true;
        boolean include = true;

        for (int i=0;i<numbers.length();i++){
            int tmp = numbers.charAt(i) - '0';
            num[tmp]++;
        }
        for (int i=2;i<Math.pow(10, numbers.length());i++){
            for (int j=2;j<=Math.sqrt(i);j++){
                if (i%j==0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                String prime_num = String.valueOf(i);
                int[] count_num = new int[10];
                for (int j=0;j<prime_num.length();j++){
                    int tmp = prime_num.charAt(j) - '0';
                    count_num[tmp]++;
                }

                for (int j=0;j<10;j++){
                    if (num[j] < count_num[j])
                        include = false;
                }
                if (include)
                    answer++;
                include = true;
            }
            prime = true;
        }
        return answer;
    }
}
