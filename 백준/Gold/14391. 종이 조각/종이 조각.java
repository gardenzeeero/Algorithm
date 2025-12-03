import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        init();

        int limit = 1 << (n * m);
        int answer = 0;
        for (int i = 1; i <= limit; i++) {
            answer = Math.max(answer, findSum(i));
        }

        System.out.println(answer);
    }

    static int findSum(int right) {
        boolean[][] used = new boolean[n][m];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (used[i][j]) continue;
                sum += getSum(i, j, right, used);
            }
        }
        return sum;
    }

    static int getSum(int x, int y, int right, boolean[][] used) {
        int idx = x * m + y;
        boolean isRight = (right & (1 << idx)) != 0;
        int dir = isRight ? 1 : 0;

        int sum = arr[x][y];
        used[x][y] = true;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) return sum;

            int nxtIdx = nx * m + ny;
            int nxtDir = (right & (1 << nxtIdx)) != 0 ? 1 : 0;

            if (nxtDir != dir) return sum;

            sum *= 10;
            sum += arr[nx][ny];
            used[nx][ny] = true;

            x = nx;
            y = ny;
        }
    }


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
