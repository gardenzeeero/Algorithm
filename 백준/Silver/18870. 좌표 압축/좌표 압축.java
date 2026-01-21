import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] result, sorted;
    static ArrayList<Integer> unique;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sorted = new int[n];
        System.arraycopy(input, 0, sorted, 0, n);
        Arrays.sort(sorted);

        unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                unique.add(sorted[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = find(input[i]);
            bw.write(count + " ");
        }
        
        bw.flush();

    }

    static int find(int target) {
        int left = 0;
        int right = unique.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (unique.get(mid) == target) return mid;
            else if (unique.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
