import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] parent;
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for (int i=1; i<=n; i++) parent[i] = i;

            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int count = 0;
            for (int i=1; i<=n; i++) {
                if (parent[i] == i) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int child) {
        if (child == parent[child]) return child;
        return parent[child] = find(parent[child]);
    }

    static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);

        if (p1 != p2) parent[p1] = p2;
    }
}