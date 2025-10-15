import java.io.*;
import java.util.*;
import static java.lang.System.in;
import static java.util.Arrays.stream;

public class Main {

    static long t;
    static int n, m;
    static long[] sumA, sumB;

    static Map<Long, Integer> aCount = new HashMap<>();
    static Map<Long, Integer> bCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        // A의 모든 부분합 카운팅: 0 ≤ i < j ≤ n
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                long key = sumA[j] - sumA[i];
                aCount.put(key, aCount.getOrDefault(key, 0) + 1);
            }
        }

        // B의 모든 부분합 카운팅: 0 ≤ i < j ≤ m
        for (int i = 0; i <= m - 1; i++) {
            for (int j = i + 1; j <= m; j++) {
                long key = sumB[j] - sumB[i];
                bCount.put(key, bCount.getOrDefault(key, 0) + 1);
            }
        }

        long answer = 0L;
        for (Map.Entry<Long, Integer> e : aCount.entrySet()) {
            long need = t - e.getKey();
            Integer cnt = bCount.get(need);
            if (cnt != null) answer += (long) e.getValue() * cnt;
        }

        System.out.print(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        // t
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = input[0];

        // A
        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        sumA = new long[n + 1]; // sumA[0] = 0
        int[] arrA = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++) sumA[i] = arrA[i - 1];
        for (int i = 1; i <= n; i++) sumA[i] = sumA[i - 1] + sumA[i]; // <= n (중요)

        // B
        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0];
        sumB = new long[m + 1];
        int[] arrB = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= m; i++) sumB[i] = arrB[i - 1];
        for (int i = 1; i <= m; i++) sumB[i] = sumB[i - 1] + sumB[i]; // <= m (중요)
    }
}