import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {
    static int n, q;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        q = input[1];

        arr = stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        int x, y, a, b;
        for (int i = 0; i < q; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x = input[0];
            y = input[1];
            a = input[2];
            b = input[3];

            if (x <= y) {
                System.out.println(getSum(x - 1, y - 1));
            } else {
                System.out.println(getSum(y - 1, x - 1));
            }

            updateSum(a - 1, b);
        }

    }

    static long getSum(int x, int y) {
        long prev = 0;
        if (x != 0) prev = arr[x - 1];
        long next = arr[y];

        return next - prev;
    }

    static void updateSum(int a, int b) {
        long prev = getSum(a, a);
        long diff = b - prev;
        for (int i = a; i < n; i++) {
            arr[i] += diff;
        }
    }
}
