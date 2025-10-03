import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int r, c;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Node {
        int cr, cc;

        public Node(int cr, int cc) {
            this.cr = cr;
            this.cc = cc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = input[0];
        c = input[1];

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int tryCount = Integer.parseInt(br.readLine());
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < tryCount; i++) {
            if (i % 2 == 0) {
                throwStick(true, input[i]);
            } else {
                throwStick(false, input[i]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void throwStick(boolean fromLeft, int height) {
        height = r - height;
        if (fromLeft) {
            for (int i = 0; i < c; i++) {
                if (map[height][i] == '.') continue;
                map[height][i] = '.';
                dropMineral(height, i);
                break;
            }
        } else {
            for (int i = c - 1; i >= 0; i--) {
                if (map[height][i] == '.') continue;
                map[height][i] = '.';
                dropMineral(height, i);
                break;
            }
        }
    }

    static void dropMineral(int sr, int sc) {
        for (int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];
            if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
            if (map[nr][nc] == '.') continue;
            boolean[][] visited = canGoFloor(nr, nc);
            if (visited == null) continue;
            dropCluster(visited);
        }
    }

    static boolean[][] canGoFloor(int sr, int sc) {
        if (sr == r - 1) return null;

        boolean[][] visited = new boolean[r][c];
        visited[sr][sc] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sr, sc));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.cr + dr[i];
                int ny = cur.cc + dc[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '.') continue;

                if (nx == r - 1) return null;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

        return visited;
    }

    static void dropCluster(boolean[][] visited) {
        while (true) {
            if (!canDrop(visited)) break;


            for (int i = r - 1; i >= 0; i--) {
                if (!canGo(i, visited)) break;

                for (int j = 0; j < c; j++) {
                    if (!visited[i][j]) continue;
                    visited[i][j] = false;
                    visited[i + 1][j] = true;
                    map[i + 1][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }

    }

    static boolean canGo(int sr, boolean[][] visited) {
        for (int i = 0; i < c; i++) {
            if (map[sr][i] == '.') continue;
            if (!visited[sr][i]) continue;
            if (map[sr + 1][i] != '.') return false;
        }
        return true;
    }

    static boolean canDrop(boolean[][] visited) {
        for (int i = 0; i < c; i++) {
            for (int j = r - 1; j >= 0; j--) {
                if (map[j][i] != 'x' || !visited[j][i]) continue;

                if (j == r - 1) return false;
                if (map[j + 1][i] == 'x') return false;
                break;
            }
        }

        return true;
    }
}
