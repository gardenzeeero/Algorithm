import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m, sx, sy, k;
    static int[][] dice = new int[4][3];
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        sx = input[2];
        sy = input[3];
        k = input[4];

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            map[i] = Arrays.copyOf(input, m);
        }

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = sx;
        int y = sy;
        for (int i = 0; i < k; i++) {
            int dir = input[i] - 1;

            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            rollDice(dir);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[1][1];
            } else {
                dice[1][1] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
//            for (int j = 0; j < 4; j++) {
//                for (int k = 0; k < 3; k++) {
//                    System.out.print(dice[j][k] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(dice[3][1]);
        }

    }

    static void rollDice(int dir) {
        if (dir == 0) {
            int top = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = top;
        } else if (dir == 1) {
            int top = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = top;
        } else if (dir == 2) {
            int top = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = top;
        } else if (dir == 3) {
            int top = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = top;
        }
    }
}
