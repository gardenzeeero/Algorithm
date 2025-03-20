import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int n, m, l;
    static ArrayList<Integer> rest = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        for (int i=1; i<=1000; i++) {
            if (checkCount(i)) {
                System.out.print(i);
                break;
            }
        }

    }

    static boolean checkCount(int dist) {
        int count = 0;
        for (int i=1; i<rest.size(); i++) {
            int diff = rest.get(i) - rest.get(i-1);
            if (diff > dist) {
                count += diff / dist;
                if (diff % dist == 0) count--;
            }
        }

        return count <= m;
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; m = input[1]; l = input[2];
        rest.add(0); rest.add(l);

        if (n != 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i=0; i<n; i++) {
                rest.add(input[i]);
            }
        }

        Collections.sort(rest);
    }
}
