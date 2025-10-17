import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.util.Arrays.stream;


public class Main {

    static int m, q;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        m = input[0];
        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp = new int[m + 1][19];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = input[i - 1];
        }

        for (int i = 1; i < 19; i++) {
            for (int j = 1; j <= m; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }


        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        q = input[0];

        for (int i = 1; i <= q; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = input[0];
            int x = input[1];
            int temp = 0;
            while (n > 0) {
                if (n % 2 != 0) {
                    x = dp[x][temp]; //N이 2로 나눠 지지 않으면 x가 temp 번 감
                }
                n /= 2;
                temp++;
            }

            System.out.println(x);
        }
    }
}
