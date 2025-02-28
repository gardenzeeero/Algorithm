import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] point;
    static int[][] numbers;
    static boolean[][] isUsed;
    static int[][] dice = {
            {0, 2, 0},
            {4, 1, 3},
            {0, 5, 0},
            {0, 6, 0}
    };
    static int m, n, k, dir;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        initPoint();

        Point cur = new Point(1, 1);
        int result = 0;
        for (int i=0; i<k; i++) {
            cur = getNextPoint(cur);
            rollDice(dir);
            result += point[cur.x][cur.y];
            if (dice[3][1] > numbers[cur.x][cur.y]) dir = (dir+1)%4;
            else if (dice[3][1] < numbers[cur.x][cur.y]) {
                dir = dir - 1;
                if (dir < 0) dir = 3;
            }
        }
        System.out.print(result);
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        m = input[0]; n = input[1]; k = input[2]; dir = 0;
        point = new int[m+1][n+1];
        numbers = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j=0; j<n; j++) {
                numbers[i][j+1] = input[j];
            }
        }
    }

    static void initPoint() {
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (point[i][j] == 0) {
                    int sizeOfArea = BFS(i, j, 0);
                    BFS(i, j, sizeOfArea * numbers[i][j]);
                }
            }
        }
    }

    static int BFS(int sx, int sy, int finalPoint) {
        isUsed = new boolean[m+1][n+1];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sx, sy));
        isUsed[sx][sy] = true;
        point[sx][sy] = finalPoint;

        int sizeOfArea = 1;
        while(!q.isEmpty()) {
            Point cp = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cp.x + dx[i]; int ny = cp.y + dy[i];

                if (nx <= 0 || nx > m || ny <= 0 || ny > n) continue;
                if (numbers[cp.x][cp.y] != numbers[nx][ny]) continue;
                if (isUsed[nx][ny]) continue;
                isUsed[nx][ny] = true;
                point[nx][ny] = finalPoint;
                q.add(new Point(nx, ny));
                sizeOfArea++;
            }
        }

        return sizeOfArea;
    }

    static Point getNextPoint(Point cur) {

        int nx = cur.x + dx[dir]; int ny = cur.y + dy[dir];
        if (nx <= 0 || nx > m || ny <= 0 || ny >n ) {
            dir = (dir+2) % 4;
            nx = cur.x + dx[dir]; ny = cur.y + dy[dir];
        }

        return new Point(nx, ny);
    }

    static void rollDice(int dir) {

        if (dir == 0) {
            int temp = dice[1][2];
            dice[1] = new int[]{dice[3][1], dice[1][0], dice[1][1]};
            dice[3][1] = temp;
        } else if (dir == 1) {
            int temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1] ;
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        } else if (dir == 2) {
            int temp = dice[1][0];
            dice[1] = new int[]{dice[1][1], dice[1][2], dice[3][1]};
            dice[3][1] = temp;
        } else if (dir == 3) {
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }
    }
}
