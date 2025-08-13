import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] height;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x=x; this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int answer = 0;
        for (int i=0; i<=100; i++) {
            visited = new boolean[n][n];
            answer = Math.max(answer, check(i));
        }

        System.out.println(answer);
    }

    static int check(int targetHeight) {
        int land = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) continue;
                if (height[i][j] <= targetHeight) {
                    visited[i][j] = true;
                    continue;
                }
                bfs(i, j, targetHeight);
                land++;
            }
        }

        return land;
    }

    static void bfs(int sx, int sy, int targetHeight) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;

                if (height[nx][ny] <= targetHeight) continue;
                q.add(new Node(nx, ny));
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];

        height = new int[n][n];
        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, height[i], 0, n);
        }
    }
}
