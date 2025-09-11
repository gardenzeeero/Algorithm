import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, d;
    static int[] costs;
    static Map<Integer, ArrayList<Road>> roads = new HashMap<>();

    static class Road {
        int end, cost;

        public Road(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        d = input[1];
        costs = new int[d + 1];


        for (int i = 0; i <= d; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[1] > d) continue;
            roads.putIfAbsent(input[0], new ArrayList<>());
            roads.get(input[0]).add(new Road(input[1], input[2]));
        }

        int prev = -1;
        for (int i = 0; i <= d; i++) {
            prev++;
            if (costs[i] < prev) {
                prev = costs[i];
            } else {
                costs[i] = prev;
            }

            List<Road> rlist = roads.get(i);
            if (rlist == null) continue;
            for (Road r : rlist) {
                costs[r.end] = Math.min(costs[r.end], costs[i] + r.cost);
            }


        }

        System.out.println(costs[d]);

    }

    public static void init() throws IOException {

    }
}
