import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static int[][] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        inputs = new int[n][3];

        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, inputs[i], 0, 3);
        }

        long left = 1; long right = 2_147_483_647;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = findCount(mid);

            if (count < 0 ){
                System.out.print(mid + " ");
                System.out.print(-count);
                return;
            } else if (count % 2 == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("NOTHING");
    }

    static long findCount(long target) {
        long count = 0;
        long targetCount = 0;
        for (int i=0; i<n; i++) {
            long A = inputs[i][0];
            long B = inputs[i][1];
            long C = inputs[i][2];
            B = Math.min(B, target);
            if (A > target) continue;
            count += (B - A)/C + 1;
            if ((target - A) % C == 0 && B == target) targetCount++;
        }

        if (targetCount % 2 != 0) return -targetCount;
        else return count;
    }
}
