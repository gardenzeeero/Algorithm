import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][][] visited;
    static char[][] map;
    static int r, c;
    static int sx, sy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }

        visited = new boolean[r][c][1 << 6];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sx, sy, 0, 0));
        visited[sx][sy][getKey(map[sx][sy])] = true;

        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (visited[nx][ny][cur.keys]) continue;

                if (map[nx][ny] == '#') continue;
                if (map[nx][ny] == '1') {
                    result = Math.min(result, cur.cnt + 1);
                    continue;
                }

                //백트래킹
                if (cur.cnt + 1 >= result) continue;

                //벽이면?
                if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z') {
                    //key로 못가면
                    if ((cur.keys & (1 << (map[nx][ny] - 'A'))) == 0) continue;
                }

                int nextKeys = cur.keys;
                if ('a' <= map[nx][ny] && map[nx][ny] <= 'z') nextKeys |= getKey(map[nx][ny]);
                visited[nx][ny][nextKeys] = true;
                q.add(new Node(nx, ny, nextKeys, cur.cnt + 1));
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.print(result);
        }

    }

    static int getKey(char c) {
        if (c < 'a' || 'f' < c) return 0;
        return 1 << (c - 'a');
    }

    static class Node {
        int x, y, keys, cnt;

        public Node(int x, int y, int keys, int cnt) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.cnt = cnt;
        }
    }
}