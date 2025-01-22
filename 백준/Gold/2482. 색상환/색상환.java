import java.io.*;
import java.util.*;

public class Main {

    static long arr[][];

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        arr = new long[1001][1001];

        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;

        for (int i=2; i<=n; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                    continue;
                }

                arr[i][j] = ( arr[i-2][j-1] + arr[i-1][j] ) % 1000000003;
            }
        }

        long result = ( arr[n-1][k] + arr[n-3][k-1] ) % 1000000003;
        System.out.println(result);
    }
}
