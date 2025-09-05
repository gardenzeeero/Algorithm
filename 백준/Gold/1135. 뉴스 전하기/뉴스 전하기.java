import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] child;
    static int[] parent, dp;

    static int dfs(int u) {
        if (child[u].isEmpty()) return dp[u] = 0;

        List<Integer> times = new ArrayList<>();
        for (int v : child[u]) times.add(dfs(v));

        // 자식 서브트리 시간이 큰 것부터 먼저 전화
        times.sort(Comparator.reverseOrder());

        int best = 0;
        for (int i = 0; i < times.size(); i++) {
            best = Math.max(best, times.get(i) + i + 1);
        }
        return dp[u] = best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        parent = new int[n];
        child = new ArrayList[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) child[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) parent[i] = Integer.parseInt(st.nextToken());

        int root = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) { root = i; continue; }
            child[parent[i]].add(i);
        }

        System.out.println(dfs(root));
    }
}