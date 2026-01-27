import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[][] arr;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new long[n][n][3];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = Arrays.copyOf(input, n);
        }

        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) continue;
                update(i, j);
            }
        }

        System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j][0] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("---");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j][1] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("---");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j][2] + " ");
//            }
//            System.out.println();
//        }
    }

    //0 가로 1 세로 2 대각선
    static void update(int cx, int cy) {
        if (cx - 1 >= 0) {
            dp[cx][cy][1] += dp[cx - 1][cy][1] + dp[cx - 1][cy][2];
        }
        if (cy - 1 >= 0) {
            dp[cx][cy][0] += dp[cx][cy - 1][0] + dp[cx][cy - 1][2];
        }
        if (cx - 1 >= 0 && cy - 1 >= 0) {
            if (arr[cx - 1][cy] == 1 || arr[cx][cy - 1] == 1) return;
            dp[cx][cy][2] += dp[cx - 1][cy - 1][0] + dp[cx - 1][cy - 1][1] + dp[cx - 1][cy - 1][2];
        }
    }
}
