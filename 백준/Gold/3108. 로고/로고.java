import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

//비트마스킹
//BFS
public class Main {

    static ArrayList<Integer>[][] isSquare = new ArrayList[1001][1001];
    static boolean[][] visited = new boolean[1001][1001];
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                isSquare[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = input[0] + 500;
            int y1 = input[1] + 500;
            int x2 = input[2] + 500;
            int y2 = input[3] + 500;

            for (int j = x1; j <= x2; j++) {
                isSquare[j][y1].add(i);
                isSquare[j][y2].add(i);
            }

            for (int j = y1; j <= y2; j++) {
                isSquare[x1][j].add(i);
                isSquare[x2][j].add(i);
            }
        }

        int result = 0;


        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (isSquare[i][j].isEmpty()) continue;
                if (visited[i][j]) continue;
                draw(i, j);
                result++;
            }
        }
        if (!isSquare[500][500].isEmpty()) result--;


        System.out.println(result);
    }

    static void draw(int sx, int sy) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(sx, sy));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= 1001 || ny < 0 || ny >= 1001) continue;
                boolean canGo = false;
                for (int num : isSquare[cur.x][cur.y]) {
                    if (isSquare[nx][ny].contains(num)) {
                        canGo = true;
                        break;
                    }
                }
                if (!canGo) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Pos(nx, ny));
            }
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
