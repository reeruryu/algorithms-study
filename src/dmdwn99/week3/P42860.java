package dmdwn99.week3;

public class P42860 {
    public int solution(String name) {
        int answer = 0;
        int max_len = name.length() - 1;

        for (int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', ('Z' - name.charAt(i) + 1));

            int next = i+1;

            while (next < name.length()&&name.charAt(next) == 'A'  )
                next++;

            max_len = Math.min(max_len, i+(name.length()-next)+Math.min(i,name.length()-next));
        }

        return answer + max_len;
    }
}
