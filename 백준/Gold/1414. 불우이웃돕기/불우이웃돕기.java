import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {

    static int n;
    static Queue<Edge> edges = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        init();

        int answer = 0;

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int p1 = find(edge.start);
            int p2 = find(edge.end);
            if (p1 == p2) {
                answer += edge.cost;
            } else {
                union(p1, p2);
            }
        }

        int candidateParent = find(0);

        for (int i = 1; i < n; i++) {
            if (find(i) != candidateParent) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(answer);
    }

    static int find(int child) {
        while (parent[child] != child) {
            child = parent[child];
        }
        return child;
    }

    static void union(int p1, int p2) {
        if (p1 < p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        parent = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            char[] cinput = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (cinput[j] == '0') continue;
                int cost = 0;
                if ('a' <= cinput[j] && cinput[j] <= 'z') cost = cinput[j] - 'a' + 1;
                else cost = cinput[j] - 'A' + 27;

                edges.add(new Edge(i, j, cost));
            }
        }
    }

    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}

