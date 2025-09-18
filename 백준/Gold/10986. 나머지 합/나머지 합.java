import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        arr = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        count = new int[m];

        arr[0] %= m;
        count[arr[0]]++;

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            arr[i] %= m;
            count[arr[i]]++;
        }
        count[0]++;

        long answer = 0;
        for (int i = 0; i < m; i++) {
            if (count[i] == 0) continue;
            answer += ((long) count[i] * (long) (count[i] - 1)) / 2;
        }

        System.out.println(answer);


    }
}
