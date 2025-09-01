import javax.naming.InitialContext;
import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.*;
import java.lang.module.FindException;
import java.util.*;

public class Main {

    static int[] indegree;
    static int[] answer;
    static ArrayList<ArrayList<Integer>> after = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = input[0];

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] rank = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            after.clear();
            for (int j=0; j<=n; j++) {
                after.add(new ArrayList<>());
            }

            indegree = new int[n+1];
            answer = new int[n];
            int indegreeCount = 0;
            for (int j=0; j<n; j++) {
                indegree[rank[j]] = indegreeCount++;
                for (int k=j+1; k<n; k++) {
                    after.get(rank[j]).add(rank[k]);
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int j=0; j<m; j++) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (after.get(input[1]).contains(input[0])) {
                    indegree[input[1]]++;
                    indegree[input[0]]--;
                    after.get(input[0]).add(Integer.valueOf(input[1]));
                    after.get(input[1]).remove(Integer.valueOf(input[0]));
                } else {
                    indegree[input[0]]++;
                    indegree[input[1]]--;
                    after.get(input[1]).add(Integer.valueOf(input[0]));
                    after.get(input[0]).remove(Integer.valueOf(input[1]));
                }

            }

            if (!makeArr(n)) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int j=0; j<n; j++) {
                    System.out.print(answer[j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static boolean makeArr(int n) {
        for (int i=0; i<n; i++) {
            int next = findZeroIndegree(n);
            if (next == -1) return false;
            answer[i] = next;
            indegree[next]--;
            for (int num : after.get(next)) {
                indegree[num]--;
            }
        }

        return true;
    }

    public static int findZeroIndegree(int n) {
        int zeroCount = 0;
        int zeroIdx = 0;
        for (int i=1; i<=n; i++) {
//            System.out.print(i + "i " + indegree[i] + " ");
            if (indegree[i] == 0) {
                zeroCount++;
                zeroIdx = i;
            }
        }

        if (zeroCount > 1 || zeroCount == 0) return -1;

        return zeroIdx;
    }
}
