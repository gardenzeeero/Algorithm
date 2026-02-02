import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for (int j = 0; j < n; j++) {
                map[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j - 1 >= 0) map[j][k] += map[j - 1][k];
                    if (k - 1 >= 0) map[j][k] += map[j][k - 1];
                    if (j - 1 >= 0 && k - 1 >= 0) map[j][k] -= map[j - 1][k - 1];
                }
            }

            int result = 0;
            for (int j = m - 1; j < n; j++) {
                for (int k = m - 1; k < n; k++) {
                    int temp = map[j][k];
                    if (j - m >= 0) temp -= map[j - m][k];
                    if (k - m >= 0) temp -= map[j][k - m];
                    if (j - m >= 0 && k - m >= 0) temp += map[j - m][k - m];
                    result = Math.max(result, temp);
                }
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}