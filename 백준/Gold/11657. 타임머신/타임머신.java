import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] minTime;

    static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start; this.end = end; this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        minTime[1] = 0;
        boolean flag = false;
        for (int i=1; i<=n+1; i++) {
            for (Edge e : edges) {
                if (minTime[e.start] == Long.MAX_VALUE) continue;

                if (minTime[e.end] > minTime[e.start] + e.time) {
                    minTime[e.end] = minTime[e.start] + e.time;
                    if (i == n+1) flag = true;
                }
            }
        }

        if (flag) {
            System.out.println(-1);
        } else{
            for (int i=2; i<=n; i++) {
                if (minTime[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                }else {
                    System.out.println(minTime[i]);
                }
            }
        }
    }

    static void init() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; m = input[1];
        minTime = new long[n+1];
        Arrays.fill(minTime, Long.MAX_VALUE);

        for (int i=0; i<m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(input[0], input[1], input[2]));
        }
    }
}
