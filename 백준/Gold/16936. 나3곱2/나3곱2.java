import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static long[] arrA, arrB;
    static boolean[] isUsed;
    static int arrSize;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        init();

        for (int i=0; i<arrSize; i++) {
            isUsed[i] = true;
            arrB[0] = arrA[i];
            recursive(arrA[i], 1);
            isUsed[i] = false;
        }

    }

    static void recursive(long prev, int count) {
        if (flag) return;

        if (count == arrSize) {
            for (int i=0; i<arrSize; i++) {
                System.out.print(arrB[i] + " ");
            }
            flag = true;
            return;
        }

        for (int i=0; i<arrSize; i++) {
            if (isUsed[i]) continue;
            if (prev % 3 == 0 && prev / 3 == arrA[i]) {
                arrB[count] = arrA[i];
                isUsed[i] = true;
                recursive(arrA[i], count+1);
                isUsed[i] = false;
            }
            if (prev * 2 == arrA[i]) {
                arrB[count] = arrA[i];
                isUsed[i] = true;
                recursive(arrA[i], count+1);
                isUsed[i] = false;
            }
        }
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        arrSize = Integer.parseInt(br.readLine());
        arrA = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        arrB = new long[arrSize];
        isUsed = new boolean[arrSize];
    }
}
