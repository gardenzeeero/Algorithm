import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0]; n = input[1];
        arr = new int[m][m];

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            applyInput(arr, input);
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<m; j++) {
                arr[i][j] = arr[i-1][j];
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void applyInput(int[][] arr, int[] input) {
        int idx = 0;
        for (int i=m-1; i>=0; i--) {
            while (input[idx] == 0) idx++;
            arr[i][0] += idx;
            input[idx]--;
        }

        for (int i=1; i<m; i++) {
            while (input[idx] == 0) idx++;
            arr[0][i] += idx;
            input[idx]--;
        }
    }
}
