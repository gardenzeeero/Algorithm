import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
    static int[] heavier;
    static int[] lighter;

    public static void main(String[] args) throws IOException {
        init();

        for (int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            DFS(i, i);
        }

        int limit = (n+1)/2;
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (heavier[i] >= limit || lighter[i] >= limit) answer++;
        }

        System.out.println(answer);
    }

    static void DFS(int current, int start) {
        visited[current] = true;

        int weightNum = 1;
        for (int next : parent.get(current)) {
            if (visited[next]) continue;
            lighter[next]++;
            heavier[start]++;
            DFS(next, start);
        }
    }


    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            parent.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            parent.get(input[1]).add(input[0]);
        }
        heavier = new int[n+1];
        lighter = new int[n+1];
    }
}
