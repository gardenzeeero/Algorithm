import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);

        int zeroCount = 0;
        for (int i=0; i<n; i++) {
            if (input[i] == 0) zeroCount++;

            for (int j=i+1; j<n; j++) {
                int sum = input[i] + input[j];
                Integer count = counts.get(sum);
                if (count == null) counts.put(sum, 1);
                else counts.put(sum, count+1);
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            Integer count = counts.get(input[i]);
            if (count == null) continue;

            if (input[i] == 0) count -= zeroCount - 1;
            else count -= zeroCount;
            if (count > 0) answer++;
        }

        System.out.println(answer);
    }
}
