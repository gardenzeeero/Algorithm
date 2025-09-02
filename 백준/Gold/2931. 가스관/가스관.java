import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int r, c;
    static int sx, sy;
    static int tx, ty;
    static int dir;

    static char[][] map;

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        init();


        Node n = findTarget();
        n.x++;
        n.y++;
        if (n.cost == 3) System.out.println(n.x + " " + n.y + " " + '|');
        else if (n.cost == 7) System.out.println(n.x + " " + n.y + " " + '-');
        else if (n.cost == 10) System.out.println(n.x + " " + n.y + " " + '+');
        else if (n.cost == 9) System.out.println(n.x + " " + n.y + " " + '1');
        else if (n.cost == 6) System.out.println(n.x + " " + n.y + " " + '2');
        else if (n.cost == 1) System.out.println(n.x + " " + n.y + " " + '3');
        else if (n.cost == 4) System.out.println(n.x + " " + n.y + " " + '4');


    }

    static Node findTarget() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '.') continue;

                int cost = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    char block = map[nx][ny];

                    if (k == 0 && (block == 124 || block == '+' || block == '1' || block == '4')) {
                        cost += 0;
                    } else if (k == 1 && (block == '-' || block == '+' || block == '1' || block == '2')) {
                        cost += 1;
                    } else if (k == 2 && (block == 124 || block == '+' || block == '2' || block == '3')) {
                        cost += 3;
                    } else if (k == 3 && (block == '-' || block == '+' || block == '3' || block == '4')) {
                        cost += 6;
                    }
                }
                if (cost > 0) return new Node(i, j, cost);
            }
        }

        return null;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        r = input[0];
        c = input[1];
        map = new char[r][c];


        for (int i = 0; i < r; i++) {
            char[] cinput = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = cinput[j];
                if (cinput[j] == 'M') {
                    sx = i;
                    sy = j;
                } else if (cinput[j] == 'Z') {
                    tx = i;
                    ty = j;
                }
            }
        }
    }
}
