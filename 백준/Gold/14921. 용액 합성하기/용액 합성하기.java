import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minResult = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;


        for (int i = 0; i < n - 1; i++) {
            int closestIdx = Arrays.binarySearch(arr, i + 1, n, -arr[i]);

            if (closestIdx < 0) {
                closestIdx = -(closestIdx + 1);
            }

            if (closestIdx != n && minResult > Math.abs(arr[closestIdx] + arr[i])) {
                minResult = Math.abs(arr[closestIdx] + arr[i]);
                result = arr[closestIdx] + arr[i];
            }
            if (closestIdx - 1 != i && minResult > Math.abs(arr[closestIdx - 1] + arr[i])) {
                minResult = Math.abs(arr[closestIdx - 1] + arr[i]);
                result = arr[closestIdx - 1] + arr[i];
            }
        }

        System.out.println(result);
    }
}
