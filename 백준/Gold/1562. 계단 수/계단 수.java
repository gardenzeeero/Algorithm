import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.util.Arrays.stream;

/**
 * 일단 10개로 계단수의 개수를 구하고
 * 거기서 앞에 추가하는 경우, 뒤에 추가하는 경우
 * 10 , 18, 36,
 * 0, 9 = 1 -> 2개 -> 총 4개
 * 1, 2, 4, 8개 -> 2개 => 총 16개 -> 2개씩 -> 총 32개
 *
 */

public class Main {

    static int n;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];

        if (n < 10) {
            System.out.print(0);
            return;
        }

        dp = new int[n + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        int bitRange = 1 << 10;
        int mod = 1000000000;
        //i = 자리수, j = 마지막 수
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < bitRange; k++) {
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % mod;
                    } else if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % mod;
                    } else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % mod;
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % mod;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n][i][bitRange - 1]) % mod;
        }

        System.out.println(answer);


    }
}
