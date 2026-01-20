import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    static int n, m, k;
    static ArrayDeque<Fire> fires = new ArrayDeque<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];
        k = input[2];

        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fires.add(new Fire(input[0] - 1, input[1] - 1, input[2], input[3], input[4]));
        }

        for (int i = 0; i < k; i++) {
            for (Fire fire : fires) {
                fire.move();
            }

            sumFire();
        }

        int result = 0;
        for (Fire fire : fires) {
            result += fire.mess;
        }

        System.out.println(result);
    }

    static void sumFire() {
        ArrayDeque<Fire>[][] arr = new ArrayDeque[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayDeque<>();
            }
        }


        int loop = fires.size();

        for (int i = 0; i < loop; i++) {
            Fire fire = fires.poll();
            arr[fire.x][fire.y].add(fire);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].isEmpty()) continue;
                if (arr[i][j].size() == 1) {
                    fires.add(arr[i][j].poll());
                    continue;
                }

                int fireCount = arr[i][j].size();
                Fire firstFire = arr[i][j].poll();
                int messSum = firstFire.mess, speedSum = firstFire.speed;

                boolean isSameDir = true;

                while (!arr[i][j].isEmpty()) {
                    Fire fire = arr[i][j].poll();
                    messSum += fire.mess;
                    speedSum += fire.speed;
                    if (isSameDir && (firstFire.dir % 2 != fire.dir % 2)) {
                        isSameDir = false;
                    }
                }

                if (messSum / 5 == 0) continue;

                for (int t = 0; t < 4; t++) {
                    if (isSameDir) {
                        fires.add(new Fire(i, j, messSum / 5, speedSum / fireCount, t * 2));
                    } else {
                        fires.add(new Fire(i, j, messSum / 5, speedSum / fireCount, t * 2 + 1));
                    }
                }
            }
        }
    }

    static class Fire {
        int x, y, mess, dir, speed;

        public Fire(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.mess = m;
            this.dir = d;
            this.speed = s;
        }

        public void move() {
            int loop = speed % n;

            for (int i = 0; i < loop; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0) nx = n - 1;
                else if (nx >= n) nx = 0;
                if (ny < 0) ny = n - 1;
                else if (ny >= n) ny = 0;

                x = nx;
                y = ny;
            }
        }
    }
}
