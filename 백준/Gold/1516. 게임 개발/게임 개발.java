import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> next = new ArrayList<>();
    static int[] indegree;
    static int[] time; //입력 시간
    static int[] finalTime;

    public static void main(String[] args) throws IOException {
        init();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] != 0) continue;
            q.add(i);
            finalTime[i] = time[i];
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nextBuilding : next.get(cur)) {
                indegree[nextBuilding]--;
                if (indegree[nextBuilding] == 0) {
                    q.add(nextBuilding);
                }
                finalTime[nextBuilding] = Math.max(finalTime[nextBuilding], finalTime[cur] + time[nextBuilding]);
            }
        }


        for (int i = 1; i <= n; i++) {
            System.out.println(finalTime[i]);
        }

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        for (int i = 0; i <= n; i++) {
            next.add(new ArrayList<>());
        }

        indegree = new int[n + 1];
        time = new int[n + 1];
        finalTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            time[i] = input[0];
            for (int j = 1; j < input.length - 1; j++) {
                next.get(input[j]).add(i);
                indegree[i]++;
            }
        }
    }
}
