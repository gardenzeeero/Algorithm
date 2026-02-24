import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] memo;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        map = new int[n][m];
        memo = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    memo[i][j][k] = Integer.MIN_VALUE / 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        System.out.print(findMax(0, 0, 2));
    }

    static int findMax(int x, int y, int pDir) {
        if (memo[x][y][pDir] != Integer.MIN_VALUE / 2) return memo[x][y][pDir];
        if (x == n - 1 && y == m - 1) {
            return map[x][y];
        }

        int max = Integer.MIN_VALUE / 2;
        for (int i = 1; i <= 3; i++) {
            if (i == (pDir + 2) % 4) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            max = Math.max(max, map[x][y] + findMax(nx, ny, i));
        }

        memo[x][y][pDir] = max;
        return max;
    }
}