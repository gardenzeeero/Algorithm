import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n;
    static int result = Integer.MAX_VALUE;
    static int[] people;
    static ArrayList<ArrayList<Integer>> close = new ArrayList<>();
    static int[] area;

    public static void main(String[] args) throws IOException {
        init();

        recursive(1);

        if (result == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(result);
    }

    static void recursive(int areaNum) {
        if (areaNum == n+1) {
            int diff = findDiff();
            if (diff != -1) {
                result = Math.min(result, diff);
            }
            return;
        }

        area[areaNum] = 0;
        recursive(areaNum+1);

        area[areaNum] = 1;
        recursive(areaNum+1);
    }

    static int findDiff() {
        boolean[] visited = new boolean[n+1];

        int notVisited = findNotVisited(visited);
        int area0Size = BFS(visited, notVisited);

        notVisited = findNotVisited(visited);
        if (notVisited == -1) return -1;
        int area1Size = BFS(visited, notVisited);

        notVisited = findNotVisited(visited);
        if (notVisited != -1) return -1;

        return Math.abs(area0Size - area1Size);
    }

    static int BFS(boolean[] visited, int st) {
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count += people[cur];
            for (int nx : close.get(cur)) {
                if (visited[nx]) continue;
                if (area[nx] != area[st]) continue;
                visited[nx] = true;
                q.add(nx);
            }
        }

        return count;
    }

    static int findNotVisited(boolean[] visited) {
        for (int i=1; i<=n; i++) {
            if (!visited[i]) return i;
        }
        return -1;
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        people = new int[n+1];
        area = new int[n+1];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(input, 0, people, 1, n);

        close.add(new ArrayList<>());

        for (int i=1; i<=n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> temp  = new ArrayList<>();
            for (int j=1; j<=input[0]; j++) temp.add(input[j]);
            close.add(temp);
        }
    }
}
