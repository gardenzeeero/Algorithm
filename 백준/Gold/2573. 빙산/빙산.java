import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, arr[i], 0, m);
        }

        int year = 1;
        while (true) {
            boolean melted = melt();
            if (!melted) {
                System.out.println(0);
                break;
            }
            int group = checkGroup();
            if (group >= 2) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }

    static int checkGroup() {
        int count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                if (visited[i][j]) continue;
                makeGroup(i, j);
                count++;
            }
        }

        return count;
    }

    static void makeGroup(int x, int y) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new Pos(nx, ny));
            }
        }
    }

    static boolean melt() {
        boolean melted = false;
        int[][] newArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                melted = true;

                int zeroCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (arr[nx][ny] != 0) continue;
                    zeroCount++;
                }

                if (arr[i][j] - zeroCount < 0) newArr[i][j] = 0;
                else newArr[i][j] = arr[i][j] - zeroCount;
            }
        }

        arr = newArr;

        return melted;
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
