import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] used;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        used = new boolean[n + 1];
        permutation(0);
    }

    static void permutation(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            arr[cnt] = i;
            permutation(cnt + 1);
            used[i] = false;
        }
    }
}