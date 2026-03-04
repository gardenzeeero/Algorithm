import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] dp;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 0; i <= m; i++) dp[0][i] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (dp[i][j] < 0) dp[i][j] = Integer.MAX_VALUE;
            }
        }

        if (dp[n][m] < k) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (dp[n - 1][m] >= k) {
                sb.append("a");
                n--;
            } else {
                sb.append("z");
                k -= dp[n - 1][m];
                m--;
            }
        }
        
        for (int i = 0; i < m; i++) sb.append('z');
        for (int i = 0; i < n; i++) sb.append('a');


        System.out.print(sb);
    }
}