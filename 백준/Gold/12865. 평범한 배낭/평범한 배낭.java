import javax.xml.crypto.OctetStreamData;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int n, k;

    static ArrayList<Present> presents = new ArrayList<>();
    static int[][] values;

    static class Present {
        int cost, weight;
        public Present(int cost, int weight) {
            this.cost = cost; this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i=1; i<=n; i++) {
            Present present = presents.get(i-1);
            for (int w=1; w<=k; w++) {
                if (w - present.weight < 0) {
                    values[w][i] = values[w][i-1];
                    continue;
                }

                values[w][i] = Math.max(values[w][i-1], values[w-present.weight][i-1] + present.cost);
            }
        }

        System.out.println(values[k][n]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];

        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            presents.add(new Present(input[1], input[0]));
        }

        values = new int[k+1][n+1];
    }
}
