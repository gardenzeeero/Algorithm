import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] arr1;
    static int[][] arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0]; n = input[1];
        arr1 = new int[m][m];
        arr2 = new int[m][m];

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                arr1[i][j] = 1;
            }
        }

        int[][] nextArr = arr2;
        int[][] prevArr = arr1;

        int leftDiff = 0, upDiff = 0, leftUpDiff = 0, maxDiff = 0;
        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            applyInput(prevArr, nextArr, input);

            for (int j=1; j<m; j++) {
                for (int k=1; k<m; k++) {
                    leftDiff = nextArr[j][k-1] - prevArr[j][k-1];
                    upDiff = nextArr[j-1][k] - prevArr[j-1][k];
                    leftUpDiff = nextArr[j-1][k-1] - prevArr[j-1][k-1];
                    maxDiff = Math.max(Math.max(leftDiff, upDiff), leftUpDiff);

                    nextArr[j][k] = prevArr[j][k] + maxDiff;
                }
            }

            int[][] temp = prevArr;
            prevArr = nextArr;
            nextArr = temp;
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                sb.append(prevArr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void applyInput(int[][] prevArr, int[][] nextArr, int[] input) {
        int idx = 0;
        for (int i=m-1; i>=0; i--) {
            if (input[idx] == 0) idx++;
            nextArr[i][0] = prevArr[i][0] + idx;
            input[idx]--;
        }

        for (int i=1; i<m; i++) {
            if (input[idx] == 0) idx++;
            nextArr[0][i] = prevArr[0][i] + idx;
            input[idx]--;
        }
    }
}
