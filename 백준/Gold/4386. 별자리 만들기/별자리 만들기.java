import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

import static java.lang.System.in;
import static java.util.Arrays.stream;


/**
 * 별들과의 거리가 다 있어야한다.
 * 다 하면 50 * 99 -> 5000
 */
public class Main {

    static int n;
    static int[] parent;
    static Star[] stars;
    static PriorityQueue<Edge> q = new PriorityQueue<>((e1, e2) -> Double.compare(e1.cost, e2.cost));

    static class Edge {
        int st, end;
        Double cost;

        public Edge(int st, int end, Double cost) {
            this.st = st;
            this.end = end;
            this.cost = cost;
        }
    }

    static class Star {
        Double x, y;

        public Star(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];

        stars = new Star[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            double[] dinput = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            stars[i] = new Star(dinput[0], dinput[1]);
            parent[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                q.add(new Edge(i, j, Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2))));
            }
        }


        Double answer = 0.0;
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int p1 = find(cur.st);
            int p2 = find(cur.end);

            if (p1 == p2) continue;

            union(p1, p2);
            answer += cur.cost;
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
        if (p1 < p2) parent[p1] = p2;
        else parent[p2] = p1;
    }
}

