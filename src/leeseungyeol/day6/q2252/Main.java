package leeseungyeol.day6.q2252;

import java.util.*;

// ## 위상정렬 (Topological Sort) -> 단방향, 사이클 없는 그래프에서 적용
// 스케쥴링에서 적용 (어떤애가 어떤에 앞에, 즉 방향성 있고, 사이클도 없음)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int taller = scanner.nextInt();
            int shorter = scanner.nextInt();

            // 그래프에 큰애의 노드에다가 작은애들 삽입
            graph[taller].add(shorter);
            inDegree[shorter]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

//        System.out.println(queue);

        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();
            result.add(current);

            for (int next : graph[current]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int student : result) {
            System.out.print(student + " ");
        }
    }
}
