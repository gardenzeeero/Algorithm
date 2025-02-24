import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, result;
    static ArrayList<ArrayList<Integer>> isUsed;

    public static void main(String[] args) throws IOException {
        init();

        placeQueen(0);

        System.out.println(result);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        result = 0;
        isUsed = new ArrayList<>();
        for (int i=0; i<3; i++) {
            isUsed.add(new ArrayList<>());
        }
    }

    static void placeQueen(int curRow) {
        if (curRow == n) {
            result++;
            return;
        }

        //0은 열, 1은 합, 2는 차
        for (int col=0; col<n; col++) {
            if (isUsed.get(0).contains(col)
                    || isUsed.get(1).contains(curRow + col)
                    || isUsed.get(2).contains(curRow - col)
            ) continue;

            isUsed.get(0).add(col);
            isUsed.get(1).add(curRow + col);
            isUsed.get(2).add(curRow - col);
            placeQueen(curRow+1);
            isUsed.get(0).remove(Integer.valueOf(col));
            isUsed.get(1).remove(Integer.valueOf(curRow + col));
            isUsed.get(2).remove(Integer.valueOf(curRow - col));
        }
    }
}