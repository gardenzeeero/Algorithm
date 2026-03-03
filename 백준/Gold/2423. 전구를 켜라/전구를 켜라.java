import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] visited;
    static char[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] combi = {
            {'\\', '/', ' ', '/', '/', ' ', '/', '\\'},
            {' ', '\\', '/', '\\', '\\', '/', '\\', ' '}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Node> q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cnt, n2.cnt));
        if (map[0][0] == '\\') {
            q.add(new Node(0, 0, 0, 0));
            visited[0][0][0] = 0;
        } else {
            q.add(new Node(0, 0, 0, 1));
            visited[0][0][1] = 1;
        }

        int result = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nextDir;
                if (combi[cur.dir][i] == '\\') nextDir = 0;
                else if (combi[cur.dir][i] == '/') nextDir = 1;
                else continue;

                int nextCnt = cur.cnt;
                if (map[nx][ny] != combi[cur.dir][i]) nextCnt++;

                if (visited[nx][ny][nextDir] <= nextCnt) continue;
                visited[nx][ny][nextDir] = nextCnt;
                q.add(new Node(nx, ny, nextDir, nextCnt));

            }
        }


        if (visited[n - 1][m - 1][0] == Integer.MAX_VALUE) {
            if (n - 1 == 0 && m - 1 == 0) System.out.println(1);
            else System.out.println("NO SOLUTION");
        } else {
            System.out.println(visited[n - 1][m - 1][0]);
        }

    }

    static class Node {
        int x, y, dir, cnt;

        Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}