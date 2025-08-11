import java.util.*;
import java.io.*;

public class Main {

    static int[][] inputIsland;
    static int[][] island;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int landCount = 1;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int st, end, cost;
        public Edge(int st, int end, int cost) {
            this.st = st; this.end = end; this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        checkIsland();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (island[i][j] == 0) continue;
                for (int k=0; k<4; k++) {
                    Edge foundEdge = findEdge(i, j, k);
                    if (foundEdge != null) pq.add(foundEdge);
                }
            }
        }


        parent = new int[landCount+1];
        int answer = 0;
        int count = 0;
        while (count != landCount-2) {
            Edge edge = pq.poll();
            if (edge == null) {
                answer = -1;
                break;
            }
            int p1 = find(edge.st);
            int p2 = find(edge.end);
            if (p1 == p2) continue;
            union(p1, p2);
            answer += edge.cost;
            count++;
        }

        System.out.println(answer);
    }

    static void union(int p1, int p2) {
        if (p1 < p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    static int find(int child) {
        while (parent[child] != 0) {
            child = parent[child];
        }
        return child;
    }

    static Edge findEdge (int sx, int sy, int dir) {
        int firstLand = island[sx][sy];
        int cost = 0;

        int nx, ny;
        while (true) {
            nx = sx + dx[dir]; ny = sy + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) return null;
            if (island[nx][ny] == firstLand) return null;
            if (island[nx][ny] != 0 && island[nx][ny] != firstLand) break;
            cost++;
            sx = nx; sy = ny;
        }

        if (cost < 2) {
            return null;
        }

        return new Edge(firstLand, island[nx][ny], cost);
    }

    static void checkIsland() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (inputIsland[i][j] == 0 || island[i][j] != 0) continue;
                BFS(i, j, landCount);
                landCount++;
            }
        }
    }

    static void BFS(int sx, int sy, int landNum) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        island[sx][sy] = landNum;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i]; int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (inputIsland[nx][ny] != 1 || island[nx][ny] != 0) continue;
                island[nx][ny] = landNum;
                q.add(new Node(nx, ny));
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; m = input[1];
        inputIsland = new int[n][m];
        island = new int[n][m];

        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, inputIsland[i], 0, m);
        }
    }
}
