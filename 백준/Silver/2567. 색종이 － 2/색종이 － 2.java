import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] page = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        init();

        int answer = 0;
        for (int i=0; i<101; i++) {
            for (int j=0; j<101; j++) {
                if (!page[i][j]) continue;
                answer += check(i, j);
            }
        }

        System.out.println(answer);
    }

    static int check(int sx, int sy) {
        int white = 0;
        for (int i=0; i<4; i++) {
            int nx = sx + dx[i]; int ny = sy + dy[i];
            if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                white++;
                continue;
            }
            if (!page[nx][ny]) white++;
        }
        return white;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];

        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fill(input[0], input[1]);
        }
    }

    static void fill(int sx, int sy) {
        for (int i=sx; i<sx+10; i++) {
            for (int j=sy; j<sy+10; j++) {
                page[i][j] = true;
            }
        }
    }
}
