import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            edges = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }
            visited = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                edges[first].add(second);
                edges[second].add(first);
            }

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                if (!makeGroup(i)) result++;
            }

            if (result == 0) System.out.println("Case " + caseCount + ": No trees.");
            if (result == 1) System.out.println("Case " + caseCount + ": There is one tree.");
            if (result > 1) System.out.println("Case " + caseCount + ": A forest of " + result + " trees.");

            caseCount++;
        }


    }

    static boolean makeGroup(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, start});
        visited[start] = true;

        boolean looped = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int next : edges[cur[1]]) {
                if (next == cur[0]) continue;

                if (visited[next]) {
                    looped = true;
                    continue;
                }


                visited[next] = true;
                q.add(new int[]{cur[1], next});
            }
        }

        return looped;
    }
}