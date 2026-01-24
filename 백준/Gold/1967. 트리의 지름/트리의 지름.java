import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static int n;
    static HashMap<Integer, ArrayList<Edge>> edges = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }


        for (int i = 0; i < n - 1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            ArrayList<Edge> list = edges.get(input[0]);
            list.add(new Edge(input[1], input[2]));
            list = edges.get(input[1]);
            list.add(new Edge(input[0], input[2]));
        }

        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(1, 0));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int maxDist = 0;
        int maxIdx = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (Edge edge : edges.get(cur.st)) {
                if (visited[edge.end]) continue;
                visited[edge.end] = true;
                q.add(new Pos(edge.end, cur.dist + edge.dist));
                if (cur.dist + edge.dist > maxDist) {
                    maxDist = cur.dist + edge.dist;
                    maxIdx = edge.end;
                }
            }
        }

        q.add(new Pos(maxIdx, 0));
        visited = new boolean[n + 1];
        visited[maxIdx] = true;
        maxDist = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (Edge edge : edges.get(cur.st)) {
                if (visited[edge.end]) continue;
                visited[edge.end] = true;
                q.add(new Pos(edge.end, cur.dist + edge.dist));
                if (cur.dist + edge.dist > maxDist) {
                    maxDist = cur.dist + edge.dist;
                }
            }
        }

        System.out.println(maxDist);
    }


    static class Pos {
        int st, dist;

        public Pos(int st, int dist) {
            this.st = st;
            this.dist = dist;
        }
    }

    static class Edge {
        int end, dist;

        public Edge(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
