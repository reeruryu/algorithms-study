package leeseungyeol.q42586;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        // 각 작업의 배포까지 걸리는 일수 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        int count = 0;
        int prev = queue.poll();  // 첫 번째 작업의 배포 일수

        // 각 작업의 배포 일수를 비교하면서 배포 가능한 작업 수 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (prev >= current) {
                count++;
            } else {
                resultList.add(count + 1);
                count = 0;
                prev = current;
            }
        }

        resultList.add(count + 1);

        // 결과 리스트를 배열로 변환하여 반환
        answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(result));  // [2, 1]

        progresses = new int[]{95, 90, 99, 99, 80, 99};
        speeds = new int[]{1, 1, 1, 1, 1, 1};
        result = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(result));  // [1, 3, 2]
    }
}

