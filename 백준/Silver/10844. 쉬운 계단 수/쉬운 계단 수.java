import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;
    static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        init();

        for (int i=1; i<=n-1; i++) {
            for (int j=0; j<=9; j++) {
                if (j == 0) {
                    dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j]) % MOD;
                } else if (j == 9) {
                    dp[i+1][j-1] = (dp[i+1][j-1] + dp[i][j]) % MOD;
                } else {
                    dp[i+1][j + 1] = (dp[i+1][j + 1] + dp[i][j]) % MOD;
                    dp[i+1][j - 1] = (dp[i+1][j - 1] + dp[i][j]) % MOD;
                }
            }
        }

        int answer = 0;

        for (int i=0; i<=9; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }

        System.out.println(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        dp = new int[n+1][10];
        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }
    }
}
