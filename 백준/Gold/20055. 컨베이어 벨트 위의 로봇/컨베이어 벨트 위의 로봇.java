import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static LinkedList<Position> belt = new LinkedList<>();
    static int n, k;
    static LinkedList<Robot> robots = new LinkedList<>();

    static class Position {
        int x;
        int count;
        public Position(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    static class Robot {
        Position p;
        public Robot(Position p) {
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        int result = 0;
        while (true){
            result++;
            rotateAll();
            takeRobot();
            rotateRobot();
            takeRobot();
            addRobot();
            int count = checkZeroCount();
            if (count >= k){
                break;
            }
        }

        System.out.print(result);
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; k = input[1];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int idx = 0;
        for (int count : input) {
            belt.add(new Position(idx++, count));
        }
    }

    static void rotateAll() {
        Position temp = belt.pollLast();
        belt.addFirst(temp);
        for (Position p : belt) {
            p.x++;
            if (p.x >= 2*n) p.x = 0;
        }
    }

    static void rotateRobot() {
        for (Robot r : robots) {
            int nx = r.p.x + 1;
            if (nx >= 2*n) nx = 0;
            Position nextPos = belt.get(nx);

            if (isRobot(nx) || nextPos.count <= 0) continue;
            nextPos.count--;
            r.p = nextPos;
        }
    }


    static boolean isRobot(int pos) {
        for (Robot r : robots) {
            if (r.p.x == pos) return true;
        }
        return false;
    }

    static void addRobot() {
        Position firstPos = belt.get(0);
        if (firstPos.count <= 0 || isRobot(0)) return;
        Robot r = new Robot(firstPos);
        firstPos.count--;
        robots.addLast(r);
    }

    static void takeRobot() {
        for (int i=0; i<robots.size(); i++){
            Robot r = robots.get(i);
            if (r.p.x == n-1) {
                robots.remove(i);
                return;
            }
        }
    }

    static int checkZeroCount() {
        int count = 0;
        for (Position p : belt) {
            if (p.count <= 0) count++;
        }
        return count;
    }
}
