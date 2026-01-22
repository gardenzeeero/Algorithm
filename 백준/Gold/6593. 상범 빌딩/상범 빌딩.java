import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    static int L, R, C;
    static String[][][] map;
    static int sx, sy, sf;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] df = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            R = input[1];
            C = input[2];
            L = input[0];
            if (input[0] == 0) break;

            map = new String[R][C][L];
            visited = new int[R][C][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] sInput = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        map[j][k][i] = sInput[k];
                        if (sInput[k].equals("S")) {
                            sx = j;
                            sy = k;
                            sf = i;
                        }
                    }
                }
                br.readLine();
            }

            int canGo = canGo();
            if (canGo == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + canGo + " minute(s).");
        }


    }

    static int canGo() {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(sx, sy, sf));
        visited[sx][sy][sf] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i], ny = cur.y + dy[i], nf = cur.f + df[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || nf < 0 || nf >= L) continue;
                if (visited[nx][ny][nf] != 0) continue;
                if (map[nx][ny][nf].equals("#")) continue;
                if (map[nx][ny][nf].equals("E")) return visited[cur.x][cur.y][cur.f];

                visited[nx][ny][nf] = visited[cur.x][cur.y][cur.f] + 1;
                q.add(new Pos(nx, ny, nf));
            }
        }

        return -1;
    }

    static class Pos {
        int x, y, f;

        public Pos(int x, int y, int f) {
            this.x = x;
            this.y = y;
            this.f = f;
        }
    }
}
