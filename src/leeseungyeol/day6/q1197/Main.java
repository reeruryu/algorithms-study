package leeseungyeol.day6.q1197;

import java.util.*;

// ## 크루스칼 알고리즘 문제


// 1. 간선 정의 (인터페이스를 구현 -> 간선의 가중치를 기준으로 비교가 가능하도록)
class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    // 생성자
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // 인터페이스 구성해야 하는 것 (간선 가중치가 어떤 것이 더 큰지)
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

}

class UnionFind {
    int[] parent;

    // 생성자
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // 자기 자신이 부모
        }
    }

    // find 메서드 (부모를 찾는 메서드.. 재귀)
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 부모의 부모
    }

    // union 메서드 (부모를 갱신하는 메서드)
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();  // Vertex 개수
        int E = scanner.nextInt();  // Edge 개수

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        // 1. 간선을 순서대로 정리한다.
        Collections.sort(edges);
        // System.out.println(edges);

        UnionFind unionFind = new UnionFind(V + 1);
        int answer = 0;

        // 2. 간선들을 돌면서 최소비용의 간선을 채택, 사이클이면 제낌
        for (Edge edge : edges) {
            // 사이클 확인 (부모가 같다면 사이클)
            if (unionFind.find(edge.from) != unionFind.find(edge.to)) {
                unionFind.union(edge.from, edge.to);
                answer += edge.weight;
            }
        }

        System.out.println(answer);
    }
}
