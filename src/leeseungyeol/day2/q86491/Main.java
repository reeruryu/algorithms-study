package leeseungyeol.day2.q86491;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int tmp;
        int max1 = 0, max2 = 0;
        for (int i = 0; i < sizes.length ; i++) {
            if(sizes[i][0] < sizes[i][1])
            {
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        for (int i = 0; i <sizes.length ; i++) {
            if(max1 <= sizes[i][0])
            {
                max1 = sizes[i][0];
            }
            if(max2 <= sizes[i][1])
            {
                max2 = sizes[i][1];
            }
        }
        answer = max1*max2;

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        int result = solution.solution(sizes);
        System.out.println(result);  // 4000

    }
}