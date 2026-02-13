import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static HashMap<Integer, Integer>[][] memo;
    static char[][] map;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        memo = new HashMap[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = new HashMap<>();
            }
        }

        find(0, 0, (1 << (map[0][0] - 'A')));
        System.out.println(memo[0][0].get(1 << (map[0][0] - 'A')));
    }

    static int find(int sx, int sy, int used) {
        if (memo[sx][sy].containsKey(used)) return memo[sx][sy].get(used);

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i], ny = sy + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (((1 << (map[nx][ny] - 'A')) & used) != 0) continue;
            count = Math.max(count, find(nx, ny, used | (1 << (map[nx][ny] - 'A'))));
        }

        memo[sx][sy].put(used, 1 + count);
        return 1 + count;
    }
}