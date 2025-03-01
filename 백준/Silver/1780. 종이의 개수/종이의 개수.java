import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n;
    static int[][] numbers;
    static int zeroCount = 0;
    static int minusCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        init();
        divide(0, 0, n);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    static void divide(int sx, int sy, int paperLength) {
        if (checkAll(sx, sy, paperLength)) return;

        int newPaperLength = paperLength / 3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                divide(sx + i * newPaperLength, sy + j * newPaperLength, newPaperLength);
            }
        }
    }

    static boolean checkAll(int sx, int sy, int paperLength) {
        int expectedNum = numbers[sx][sy];

        for (int i=0; i<paperLength; i++) {
            for (int j=0; j<paperLength; j++) {
                if (numbers[sx + i][sy + j] != expectedNum) return false;
            }
        }

        if (expectedNum == -1) minusCount++;
        else if (expectedNum == 0) zeroCount++;
        else if (expectedNum == 1) oneCount++;

        return true;
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        numbers = new int[n][n];

        for (int i=0; i<n; i++) {
            numbers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
