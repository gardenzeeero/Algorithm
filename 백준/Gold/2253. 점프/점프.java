import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[] isSmall;
    static int[][] reachWith;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        n = arr[0]; m = arr[1];
        isSmall = new boolean[10001];

        int num;
        for(int i=0; i<m; i++) {
            num = Integer.parseInt(br.readLine());
            isSmall[num] = true;
        }

        reachWith = new int[10001][200];
        for (int i=0; i<10001; i++) {
            Arrays.fill(reachWith[i], Integer.MAX_VALUE);
        }

        reachWith[1][0] = 0;
        for (int i= 1; i<=n-1; i++) {
            for (int j=0; j < 200; j++) {
                if (reachWith[i][j] == Integer.MAX_VALUE) continue;
                move(i, j, reachWith[i][j]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i=1; i < 200; i++) {
            if (reachWith[n][i] < result && reachWith[n][i] != 0) result = reachWith[n][i];
        }

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    public static void move(int rock, int speed, int count) {
        for(int i=-1; i<=1; i++) {
            int nextSpeed = speed + i;
            if(nextSpeed <= 0) continue;

            int nextRock = rock + nextSpeed;
            if(nextRock <= 0 || nextRock > n || isSmall[nextRock]) continue;

            if(reachWith[nextRock][nextSpeed] <= count+1) continue;
            reachWith[nextRock][nextSpeed] = count+1;
        }
    }
}
