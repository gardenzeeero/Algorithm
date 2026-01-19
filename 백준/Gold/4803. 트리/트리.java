import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int n, m;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;
    static boolean[] hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = input[0];
            m = input[1];
            if (n == 0 && m == 0) break;

            edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                edges.add(new Edge(input[0], input[1]));
            }

            parent = new int[n + 1];
            hasCycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            findCycle();

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (i == parent[i] && !hasCycle[i]) result++;
            }
            if (result == 0) {
                System.out.println("Case " + t + ": No trees.");
            } else if (result == 1) {
                System.out.println("Case " + t + ": There is one tree.");
            } else if (result >= 2) {
                System.out.println("Case " + t + ": A forest of " + result + " trees.");
            }

            t++;
        }
    }

    static void findCycle() {
        for (Edge e : edges) {
            int p1 = find(e.start);
            int p2 = find(e.end);
            if (p1 == p2) {
                hasCycle[p1] = true;
            } else {
                int result = union(p1, p2);
                if (hasCycle[p1] || hasCycle[p2]) {
                    hasCycle[result] = true;
                }
            }
        }
    }

    static int find(int x) {
        int root = x;
        while (root != parent[root]) {
            root = parent[root];
        }

        while (x != root) {
            int temp = parent[x];
            parent[x] = root;
            x = temp;
        }

        return root;
    }

    static int union(int p1, int p2) {
        int root1 = find(p1);
        int root2 = find(p2);

        if (root1 < root2) {
            parent[root2] = root1;
            return root1;
        } else {
            parent[root1] = root2;
            return root2;
        }
    }

    static class Edge {
        int start, end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
