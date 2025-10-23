 import java.io.*;
import java.util.*;
import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {
    static final int INF = 1 << 30;

    static int n, m, s, d;
    static ArrayList<ArrayList<Edge>> edges;     // (to, w)
    static ArrayList<ArrayList<Integer>> from;   // 부모들만 저장
    static int[] dist;
    static boolean[][] blocked;                  // 간선 제거 마킹

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (true) {
            int[] nm = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nm[0]; m = nm[1];
            if (n == 0 && m == 0) break;

            int[] sd = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            s = sd[0]; d = sd[1];

            edges = new ArrayList<>(n);
            from  = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
                from.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int[] e = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                edges.get(e[0]).add(new Edge(e[1], e[2]));
            }

            blocked = new boolean[n][n];

            // 1) 최초 다익스트라 + 부모 목록 구성
            dijkstraWithParents();
            if (dist[d] >= INF) {
                System.out.println(-1);
                continue;
            }

            // 2) 최단경로 간선들만 마킹(block)
            blockShortestPathEdges();

            // 3) 마킹된 간선을 스킵하고 다시 다익스트라
            int ans = dijkstraSkipBlocked();
            System.out.println(ans >= INF ? -1 : ans);
        }
    }

    static void dijkstraWithParents() {
        dist = new int[n];
        Arrays.fill(dist, INF);
        for (int i = 0; i < n; i++) from.get(i).clear();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[s] = 0;
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], du = cur[1];
            if (du != dist[u]) continue;

            for (Edge e : edges.get(u)) {
                // 최초 탐색은 block 없음
                int v = e.to, nd = du + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    from.get(v).clear();      // 더 짧은 경로면 부모 교체
                    from.get(v).add(u);
                    pq.add(new int[]{v, nd});
                } else if (nd == dist[v]) {
                    from.get(v).add(u);       // 같은 길이면 부모 추가
                }
            }
        }
    }

    static void blockShortestPathEdges() {
        // d에서 부모들을 타고 올라가며 (u->v)를 block
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] seen = new boolean[n];
        q.add(d);
        seen[d] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : from.get(v)) {
                blocked[u][v] = true;             // 실제 삭제 대신 마킹
                if (!seen[u]) {
                    seen[u] = true;
                    q.add(u);
                }
            }
        }
    }

    static int dijkstraSkipBlocked() {
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[s] = 0;
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], du = cur[1];
            if (du != dist[u]) continue;

            for (Edge e : edges.get(u)) {
                if (blocked[u][e.to]) continue;   // 제거된 간선은 스킵
                int v = e.to, nd = du + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new int[]{v, nd});
                }
            }
        }
        return dist[d];
    }
}