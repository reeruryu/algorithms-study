package leeseungyeol.day6.q1916;

import java.util.*;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 정점의 개수
        int M = scanner.nextInt();  // 간선의 개수

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.get(from).add(new Edge(to, weight));
        }

        int start = scanner.nextInt();  // 출발점
        int end = scanner.nextInt();  // 도착점

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {

            Edge current = pq.poll();

            int toVertex = current.to;
            int weight = current.weight;

            if (weight > dist[toVertex]) {
                continue;
            }

            for (Edge edge : graph.get(toVertex)) {
                if (dist[edge.to] > dist[toVertex] + edge.weight) {
                    dist[edge.to] = dist[toVertex] + edge.weight;
                    pq.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
