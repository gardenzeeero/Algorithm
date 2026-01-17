import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    static int r, c, sharkCount;
    static ArrayList<Shark> sharks = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        r = input[0];
        c = input[1];
        sharkCount = input[2];

        for (int i = 0; i < sharkCount; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int dir = input[3];
            if (dir == 1) dir = 0;
            else if (dir == 4) dir = 1;
            sharks.add(new Shark(input[0] - 1, input[1] - 1, input[2], dir, input[4]));
        }

        int result = 0;
        for (int i = 0; i < c; i++) {
            result += takeShark(i);
            moveShark();
            removeShark();
        }

        System.out.println(result);
    }

    static void removeShark() {
        int[][] maxSizeIdx = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxSizeIdx[i][j] = -1;
            }
        }

        for (int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            if (maxSizeIdx[shark.x][shark.y] == -1) maxSizeIdx[shark.x][shark.y] = i;
            else if (shark.size > sharks.get(maxSizeIdx[shark.x][shark.y]).size) {
                maxSizeIdx[shark.x][shark.y] = i;
            }
        }

        ArrayList<Shark> newSharks = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maxSizeIdx[i][j] == -1) continue;
                newSharks.add(sharks.get(maxSizeIdx[i][j]));
            }
        }
        sharks = newSharks;
    }

    static void moveShark() {
        for (Shark shark : sharks) {
            int moveCount = 0;
            if (shark.dir == 0 || shark.dir == 2) moveCount = shark.speed % (2 * (r - 1));
            else if (shark.dir == 1 || shark.dir == 3) moveCount = shark.speed % (2 * (c - 1));

            for (int i = 0; i < moveCount; i++) {
                int nx = shark.x + dx[shark.dir];
                int ny = shark.y + dy[shark.dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    shark.dir = (shark.dir + 2) % 4;
                    i--;
                    continue;
                }
                shark.x = nx;
                shark.y = ny;
            }
        }
    }

    static int takeShark(int col) {

        int minIdx = Integer.MAX_VALUE;
        int minRow = Integer.MAX_VALUE;
        for (int i = 0; i < sharks.size(); i++) {
            Shark shark = sharks.get(i);
            if (shark.y != col) continue;
            if (shark.x < minRow) {
                minRow = shark.x;
                minIdx = i;
            }
        }

        if (minIdx == Integer.MAX_VALUE) return 0;
        else {
            int size = sharks.get(minIdx).size;
            sharks.remove(minIdx);
            return size;
        }
    }

    static class Shark {
        int x, y, dir, speed, size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.speed = speed;
            this.size = size;
        }
    }
}
