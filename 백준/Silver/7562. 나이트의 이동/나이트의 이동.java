import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int l;
    static boolean[][] visited;
    static int sx, sy, gx, gy;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int x, y, time;
        public Node(int x, int y, int time) {
            this.x = x; this.y = y; this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{

        int loop = Integer.parseInt(br.readLine());
        for (int i=0; i<loop; i++) {
            init();
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(sx, sy, 0));
            visited[sx][sy] = true;
            while(!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.x == gx && cur.y == gy) {
                    System.out.println(cur.time);
                    break;
                }

                for (int j=0; j<8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if (visited[nx][ny]) continue;

                    q.add(new Node(nx, ny, cur.time+1));
                    visited[nx][ny] = true;
                }
            }
        }


    }

    public static void init() throws IOException {
        l = Integer.parseInt(br.readLine());
        visited = new boolean[l][l];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sx = input[0]; sy = input[1];
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        gx = input[0]; gy = input[1];
    }

}
