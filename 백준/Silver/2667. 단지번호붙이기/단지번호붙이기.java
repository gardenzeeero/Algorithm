import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (arr[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }
                pq.add(BFS(i, j));
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            int answer = pq.poll();
            System.out.println(answer);
        }
    }

    static int BFS(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = true;

        int count = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i]; int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
                count++;
            }
        }

        return count;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, arr[i], 0, n);
        }
    }
}
