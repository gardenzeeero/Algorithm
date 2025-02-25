import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static int problemCount;
    static int problemInfoCount;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> haveToSolve;
    static PriorityQueue<Integer> canSolve;

    public static void main(String[] args) throws IOException {
        init();
        for (int i=0; i<problemCount; i++){
            solve();
        }
    }

    static void init() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        problemCount = input[0]; problemInfoCount = input[1];
        inDegree = new int[problemCount + 1];
        haveToSolve = new ArrayList<>(problemCount + 1);
        canSolve = new PriorityQueue<>();

        for (int i=0; i<=problemCount; i++) {
            haveToSolve.add(new ArrayList<>());
        }

        for(int i=0; i<problemInfoCount; i++) {
            input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            haveToSolve.get(input[0]).add(input[1]);
            inDegree[input[1]]++;
        }
        for (int i=1; i<=problemCount; i++) {
            if (inDegree[i] == 0) canSolve.add(i);
        }
    }

    static void solve() {
        int solvingProblem = canSolve.poll();
        System.out.print(solvingProblem + " ");

        for (Integer problem : haveToSolve.get(solvingProblem)) {
            inDegree[problem]--;
            if (inDegree[problem] == 0) canSolve.add(problem);
        }
    }

}
