import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        arr = new int[n];
        dp = new int[n][n];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(find(0, n - 1));
    }

    static int find(int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        if (arr[start] == arr[end]) return find(start + 1, end - 1);

        dp[start][end] = Math.min(find(start + 1, end), find(start, end - 1)) + 1;

        return dp[start][end];
    }
}
