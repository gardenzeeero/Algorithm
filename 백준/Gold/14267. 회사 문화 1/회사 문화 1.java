import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n, m;
    static int[] cheer;
    static int[] dad;

    public static void main(String[] args) throws IOException {
        init();

        for (int i=2; i<=n ;i++) {
            cheer[i] += cheer[dad[i]];
        }

        for (int i=1; i<=n; i++) {
            System.out.print(cheer[i] + " ");
        }

    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0]; m = input[1];
        cheer = new int[n+1];
        dad = new int[n+1];
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(input, 0, dad, 1, n);

        for (int i=0; i<m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cheer[input[0]] += input[1];
        }


    }
}
