import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n, result, takenCount;
    static int[][] space;
    static Shark baby;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Shark {
        int x, y;
        int size = 2;
        public Shark(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static class Position implements Comparable<Position>{
        int x, y, takenTime;
        public Position(int x, int y, int t) {
            this.x = x; this.y = y; this.takenTime = t;
        }

        @Override
        public int compareTo(Position p) {
            if (this.takenTime != p.takenTime) {
                return Integer.compare(this.takenTime, p.takenTime);
            }
            if (this.x != p.x) {
                return Integer.compare(this.x, p.x);
            }
            return Integer.compare(this.y, p.y);
        }
    }


    public static void main(String[] args) throws IOException {
        init();

        while (true) {
            Position foundFish = findFish();
            if (foundFish == null) break;
            eatFish(foundFish);
            result += foundFish.takenTime;
        }

        System.out.println(result);
    }

    static Position findFish() {
        Queue<Position> q = new LinkedList<>();
        boolean[][] isUsed = new boolean[n][n];

        q.add(new Position(baby.x, baby.y, 0));
        isUsed[baby.x][baby.y] = true;

        PriorityQueue<Position> pq = new PriorityQueue<>();
        while (!q.isEmpty()) {
            Position cur = q.poll();

            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i]; int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (isUsed[nx][ny] || space[nx][ny] > baby.size) continue;
                if (space[nx][ny] < baby.size && space[nx][ny] != 0) pq.add(new Position(nx, ny, cur.takenTime+1));

                isUsed[nx][ny] = true;
                q.add(new Position(nx, ny, cur.takenTime+1));
            }
        }

        return pq.poll();
    }

    static void eatFish(Position fishPosition) {
        space[fishPosition.x][fishPosition.y] = 0;
        space[baby.x][baby.y] = 0;
        baby.x = fishPosition.x;
        baby.y = fishPosition.y;
        if (++takenCount == baby.size) {
            takenCount = 0;
            baby.size++;
        }
    }


    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];

        result = 0; takenCount = 0;
        space = new int[n][n];

        for (int i=0; i<n; i++){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<n; j++) {
                if (input[j] == 9) baby = new Shark(i, j);
                space[i][j] = input[j];
            }
        }
    }
}
