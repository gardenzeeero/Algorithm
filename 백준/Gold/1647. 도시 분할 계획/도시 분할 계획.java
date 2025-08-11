import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int st, end, cost;
        public Edge(int st, int end, int cost) {
            this.st = st; this.end = end; this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int count = 0;
        int cost = 0;

        int longestEdge = 0;

        while (count != n-1) {
            Edge edge = pq.poll();
            int p1 = find(edge.st);
            int p2 = find(edge.end);
            if (p1 == p2) continue;
            union(p1, p2);
            cost += edge.cost;
            count++;
            longestEdge = Math.max(longestEdge, edge.cost);
        }

        System.out.println(cost - longestEdge);
    }

    public static void union(int p1, int p2) {
        if (p1 < p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    public static int find(int child) {
        while (parent[child] != 0) {
            child = parent[child];
        }
        return child;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0]; m = input[1];

        for (int i=0; i<m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Edge(input[0], input[1], input[2]));
        }

        parent = new int[n+1];
    }
}
