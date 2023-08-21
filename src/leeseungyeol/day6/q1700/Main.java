package leeseungyeol.day6.q1700;

import java.util.*;

// ## 그리디 문제
// 육교 문제랑 비슷
class Solution {
    int solution(int N, int K, int[] addList) {

        int answer = 0;
        Set<Integer> plugs = new HashSet<>();       // 현재 멀티탭에 꽂힌 애들
        Queue<Integer> queue = new LinkedList<>();  // 기기의 사용 순서

        // 1. 큐에 순서를 저장
        for (int device : addList) {
            queue.offer(device);
        }

        // 2. 진행
        while (!queue.isEmpty()) {

            int device = queue.poll();

            // CASE1. 만약 끼워져 있다면?
            if (plugs.contains(device)) {
                continue;
            }

            // CASE 2. 끼워진게 없고, 만약 남는 공간이 있다면?
            if (plugs.size() < N) {
                plugs.add(device);
            }
            // CASE 3. 멀티탭이 다 꽂혀져있고, 지금 넣을것도 안들어가져 있다?
            else {
                int replaceDevice = -1;
                int farIndex = -1;
                // 교체해야 할 것들 결정
                for (int plug : plugs) {

                    // 앞으로 들어올꺼에 지금 꽂혀진게 없다면 먼저 제낌
                    if (!queue.contains(plug)) {
                        replaceDevice = plug;
                        break;
                    }

                    int nextIndex = ((LinkedList<Integer>) queue).indexOf(plug);
                    if (nextIndex > farIndex) {
                        farIndex = nextIndex;
                        replaceDevice = plug;
                    }

                }

                plugs.remove(replaceDevice);
                plugs.add(device);
                answer++;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 멀티탭 개수
        int K = scanner.nextInt(); // 사용할 기기 개수
        int[] addList = new int[K]; // 기기의 리스트

        for (int i = 0; i < K; i++) {
            addList[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(addList));

        Solution solution = new Solution();
        int result = solution.solution(N, K, addList);
        System.out.println(result);
    }
}
