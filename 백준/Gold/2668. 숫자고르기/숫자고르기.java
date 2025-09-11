import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];

        arr = new int[n + 1];
        used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            boolean[] visited = new boolean[n + 1];
            findCycle(i, visited);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (used[i]) count++;
        }

        System.out.println(count);
        for (int i = 1; i <= n; i++) {
            if (used[i]) System.out.println(i);
        }

    }

    /**
     * 다음걸 가는데 만약 visited이다? - 매개변수 visited는 따로
     * idx == arr[idx] 면 return -1
     * else return idx;
     */

    static int findCycle(int cur, boolean[] visited) {
        if (visited[cur]) {
            used[cur] = true;
            if (cur == arr[cur]) return -1;
            else return cur;
        }

        visited[cur] = true;
        int last = findCycle(arr[cur], visited);
        if (last == cur) return -1;
        if (last == -1) return last;

        used[cur] = true;
        return last;
    }
}
