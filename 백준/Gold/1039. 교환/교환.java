import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int k;
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();

        k = Integer.parseInt(st.nextToken());
        visited = new boolean[1000001][k + 1];

        findMax(0);

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void findMax(int count) {
        if (count == k) {
            int num = parseInt();
            result = Math.max(result, num);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean swapped = swap(i, j);
                if (!swapped) continue;

                if (visited[parseInt()][count + 1]) {
                    swap(i, j);
                } else {
                    visited[parseInt()][count + 1] = true;
                    findMax(count + 1);
                    swap(i, j);
                }
            }
        }
    }

    static boolean swap(int i, int j) {
        if (i == 0 && nums[j] == 0) return false;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return true;
    }

    static int parseInt() {
        int num = 0;
        int multi = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            num += nums[i] * multi;
            multi *= 10;
        }

        return num;
    }

}

