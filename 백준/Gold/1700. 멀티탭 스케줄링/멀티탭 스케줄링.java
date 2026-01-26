import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 뭘 뺄지 지금 정해야하나?
 * 1 넣으려면 빼야하는데 ? -> 가장 나중에 나올거 빼자
 * 1 2 3  4넣어야함 ->
 * 1 2 3
 */


public class Main {

    static int n, k;
    static Set<Integer> plugged = new HashSet<>();
    static int[] sequence;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];

        sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        for (int i = 0; i < sequence.length; i++) {
            int cur = sequence[i];

            if (plugged.contains(cur)) continue;
            if (plugged.size() == n) {
                int victim = selectVictim(i);
                plugged.remove(victim);
                result++;
//                System.out.println(i + " " + victim);
            }

            plugged.add(cur);
        }

        System.out.println(result);
    }

    static int selectVictim(int curIdx) {
        int victim = -1;
        int maxIdx = Integer.MIN_VALUE;
        for (Integer plug : plugged) {
            int nextIdx = findNext(plug, curIdx);
            if (maxIdx < nextIdx) {
                maxIdx = nextIdx;
                victim = plug;
            }
        }

        return victim;
    }

    static int findNext(int plug, int curIdx) {
        for (int i = curIdx + 1; i < sequence.length; i++) {
            if (sequence[i] == plug) return i;
        }

        return Integer.MAX_VALUE;
    }
}
