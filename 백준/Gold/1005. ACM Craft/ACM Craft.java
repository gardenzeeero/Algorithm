import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {

    static int t, n, k;
    static int[] time;
    static ArrayList<Set<Integer>> after = new ArrayList<>();
    static ArrayList<Set<Integer>> before = new ArrayList<>();
    static int[] resultTime;

    static class Building {
        int num, time;

        public Building(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        t = input[0];

        for (int i = 0; i < t; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = input[0];
            k = input[1];

            time = new int[n + 1];
            resultTime = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                resultTime[j] = Integer.MIN_VALUE;
            }

            after = new ArrayList<>();
            before = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                after.add(new HashSet<>());
                before.add(new HashSet<>());
            }

            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, time, 1, n);

            for (int j = 0; j < k; j++) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                after.get(input[0]).add(input[1]);
                before.get(input[1]).add(input[0]);
            }

            int target = Integer.parseInt(br.readLine());
            int result = findResult(target);
            System.out.println(result);
        }
    }

    static int findResult(int target) {
        Queue<Building> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (before.get(i).isEmpty()) {
                q.add(new Building(i, time[i]));
                resultTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            Building cur = q.poll();
            for (int next : after.get(cur.num)) {
                before.get(next).remove(cur.num);
                resultTime[next] = Math.max(resultTime[next], cur.time + time[next]);
                if (before.get(next).isEmpty()) {
                    q.add(new Building(next, resultTime[next]));
                }
            }
        }
//
//        for (int i = 1; i <= n; i++) {
//            System.out.println(i + " " + resultTime[i]);
//        }

        return resultTime[target];
    }
}
