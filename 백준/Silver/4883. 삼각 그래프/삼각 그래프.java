import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int n;
    static int[][] map;
    static int[][] result;
    static int[] dx = {-1, -1, -1, 0};
    static int[] dy = {-1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            map = new int[n][3];
            result = new int[n][3];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < n; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.arraycopy(input, 0, map[i], 0, 3);
            }

            result[0][1] = map[0][1];
            result[0][2] = map[0][1] + map[0][2];

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];

                        if (nx == 0 && ny == 0) continue;
                        if (nx < 0 || nx >= n || ny < 0 || ny >= 3) continue;
                        result[i][j] = Math.min(result[i][j], result[nx][ny] + map[i][j]);
                    }
                }
            }

            System.out.println(t + ". " + result[n - 1][1]);
            t++;
        }


    }
}
