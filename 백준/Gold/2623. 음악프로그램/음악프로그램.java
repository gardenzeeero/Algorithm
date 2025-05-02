import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<Set<Integer>> mustUsed = new ArrayList<>();
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException{
        init();

        StringBuilder sb = new StringBuilder();

        int count = 0;
        while(true) {
            boolean isChanged = false;

            for (int i=1; i<=n; i++) {
                if (!mustUsed.get(i).isEmpty()) continue;
                if (isUsed[i]) continue;

                sb.append(i + "\n");
                erase(i);
                isUsed[i] = true;
                count++;
                isChanged = true;
            }

            if (!isChanged) {
                break;
            }
        }

        if (count == n)  System.out.print(sb.toString());
        else System.out.println(0);
    }

    static void erase(int target) {
        for (int i=1; i<=n; i++) {
            if (mustUsed.get(i).contains(target)) {
                mustUsed.get(i).remove(target);
            }
        }
    }

    static void init() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; m = input[1];

        isUsed = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            mustUsed.add(new HashSet<>());
        }

        for (int i=0; i<m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int inputSize = input[0];

            for (int j=inputSize; j>0 ;j--) {
                for (int k=j-1; k>0; k--) {
                    mustUsed.get(input[j]).add(input[k]);
                }
            }
        }
    }
}
