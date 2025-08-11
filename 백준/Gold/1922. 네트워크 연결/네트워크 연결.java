import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static PriorityQueue<Edge> edges = new PriorityQueue<>();
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int st, end;
        int cost;
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
        int answer = 0;

        while(true) {
            Edge edge = edges.poll();
            if (edge == null) break;
            int parent1 = find(edge.st);
            int parent2 = find(edge.end);
            if (parent1 == parent2) continue;
            union(parent1, parent2);
            answer += edge.cost;
        }

        System.out.println(answer);
    }

    public static void union(int p1, int p2) {
        parent[p1] = p2;
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
        n = input[0];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0];

        for (int i=0 ; i<m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(input[0], input[1], input[2]));
        }

        parent = new int[n+1];
    }
}
