import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] inputArr, dp;

    public static void main(String[] args) throws IOException {
        init();

        int maxDp = 1;
        dp[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            int temp = 1;
            for (int j=i+1; j<n; j++) {
                if (inputArr[i] < inputArr[j]) temp = Math.max(temp, dp[j] + 1);
            }
            dp[i] = temp;
            maxDp = Math.max(maxDp, temp);
        }

        System.out.print(n - maxDp);
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        inputArr = new int[n];
        dp = new int[n];

        for (int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }
    }

}
