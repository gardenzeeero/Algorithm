import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];

        List<List<Integer>> arr = new ArrayList<>();
        int[] indegree = new int[N+1];
        for (int i=0; i<=N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.get(input[0]).add(input[1]);
            indegree[input[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int target : arr.get(cur)) {
                indegree[target]--;
                if (indegree[target] == 0) q.add(target);
            }
        }

        System.out.println(sb.toString());
    }

}
