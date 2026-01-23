import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int result1, result2;
    static int maxSum;
    static boolean[] used;
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        maxSum = (n - 1) * 2;

        used = new boolean[(n - 1) * 2 + 1];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, map[i], 0, n);
        }

        findMax(0, 0);
        findMax(1, 0);


        System.out.println(result1 + result2);
    }

    static void findMax(int sum, int count) {

        if (sum > maxSum) {
            if (sum % 2 == 0) {
                result1 = Math.max(result1, count);
            } else {
                result2 = Math.max(result2, count);
            }
            return;
        }

        boolean canGo = false;

        int i = sum >= n - 1 ? sum - (n - 1) : 0;

        for (; i <= sum; i++) {
            int r = sum - i;
            int c = i;

            if (c >= n) break;
            if (map[r][c] == 0) continue;
            if (used[r - c + (n - 1)]) continue;

            used[r - c + (n - 1)] = true;
            findMax(sum + 2, count + 1);
            canGo = true;
            used[r - c + (n - 1)] = false;
        }

        if (!canGo) findMax(sum + 2, count);
    }
}
