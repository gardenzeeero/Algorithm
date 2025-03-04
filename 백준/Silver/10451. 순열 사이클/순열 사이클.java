import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int t;

    public static void main(String[] args) throws IOException {
        init();

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] isUsed = new boolean[n+1];
            int[] arr = new int[n+1];

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.arraycopy(input, 0, arr, 1, n);

            int result = 0;
            for (int j=1; j<=n; j++) {
                if (findCycle(isUsed, arr, j)) result++;
            }
            System.out.println(result);
        }
    }

    static boolean findCycle(boolean[] isUsed, int[] arr, int idx) {
        boolean firstCome = false;

        while (!isUsed[idx]) {
            firstCome = true;
            isUsed[idx] = true;
            idx = arr[idx];
        }

        return firstCome;
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = input[0];
    }
}
