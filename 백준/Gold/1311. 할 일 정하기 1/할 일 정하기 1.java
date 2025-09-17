import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;
import static java.util.Arrays.stream;


/**
 * 한줄이 늘어나면 했을 때 안했을 때로 나뉨
 * 쓴걸 1로 해서 더해서 막 내려가
 * 없다? -> 더 내려가서 계산해봐 ->
 *
 */
public class Main {

    static ArrayList<Map<Integer, Integer>> memos = new ArrayList<>();
    static int n;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        init();

        int answer = find(0, 0);
        System.out.println(answer);

    }

    //tUsed 상태로 왔을때 밑에서 최솟값
    static int find(int used, int now) {
        if (now == n) {
            return 0;
        }

        Integer memo = memos.get(now).get(used);
        if (memo != null) return memo;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            int tUsed = 1 << i;
            if ((tUsed & used) > 0) continue;

            tUsed = tUsed | used;
            min = Math.min(min, arr[now][i] + find(tUsed, now + 1));
        }

        memos.get(now).put(used, min);
        return min;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }

        for (int i = 0; i < n; i++) {
            memos.add(new HashMap<>());
        }

    }

}

