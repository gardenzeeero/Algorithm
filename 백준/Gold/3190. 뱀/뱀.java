import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static int n, now = 0;
    static boolean[][] applePos;

    static boolean[][] isSnake;
    static LinkedList<Position> snake = new LinkedList<>();
    static Queue<Turn> turns = new LinkedList<>();

    static int headDir = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static class Turn {
        int time;
        String dir;
        public Turn(int time, String dir) {
            this.time = time; this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        Turn nextTurn = turns.poll();
        while (true) {
            now++;
            if (!moveHead()) break;
            if (nextTurn != null && nextTurn.time == now) {
                takeTurn(nextTurn.dir);
                nextTurn = turns.poll();
            }
        }
        System.out.println(now);
    }

    static void takeTurn(String turnDir) {
        if (turnDir.equals("D")) {
            headDir = (++headDir)%4;
        } else {
            --headDir;
            if (headDir < 0) headDir = 3;
        }
    }

    static boolean moveHead() {
        Position head = snake.peekLast();
        int nx = head.x + dx[headDir]; int ny = head.y + dy[headDir];

        //부딪히면 반환
        if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
        if (isSnake[nx][ny]) return false;

        //사과가 없으면 꼬리 자르기
        if (!applePos[nx][ny]) {
            Position tail = snake.pollFirst();
            isSnake[tail.x][tail.y] = false;
        }
        applePos[nx][ny] = false; //사과 먹은걸로
        isSnake[nx][ny] = true;

        snake.addLast(new Position(nx, ny)); //진짜 머리 이동

        return true;
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        isSnake = new boolean[n][n]; isSnake[0][0] = true;
        snake.add(new Position(0,0));

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int appleCount = input[0];

        applePos = new boolean[n][n];
        for (int i=0; i<appleCount; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            applePos[input[0]-1][input[1]-1] = true;
        }

        initTurn();
    }

    static void initTurn() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int turnCount = input[0];
        for (int i=0; i<turnCount; i++) {
            String[] turnInfo = br.readLine().split(" ");
            turns.add(new Turn(Integer.parseInt(turnInfo[0]), turnInfo[1]));
        }
    }
}
