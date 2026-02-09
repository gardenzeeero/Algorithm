import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    static int n;
    static int[][] arr;
    static ArrayList<int[]> cores;
    static boolean[] used;
    static int maxCore, minWire;
    static int coreCount;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            cores = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0 || i == n - 1 || j == n - 1) continue;
                    if (arr[i][j] != 1) continue;
                    cores.add(new int[]{i, j});
                }
            }
            coreCount = cores.size();
            used = new boolean[coreCount];
            maxCore = 0;
            minWire = Integer.MAX_VALUE;
            visited = new boolean[n][n];

            findMax(0, 0);

            sb.append(minWire).append("\n");
        }

        System.out.println(sb);
    }

    static void findMax(int cnt, int selectedCnt) {
        if (cnt == coreCount) {
            int wire = getWireLength();

            int core = 0;
            for (int i = 0; i < coreCount; i++) {
                if (used[i]) core++;
            }

            if (core > maxCore) {
                maxCore = core;
                minWire = wire;
            } else if (core == maxCore && wire < minWire) {
                minWire = wire;
            }

            return;
        }

        if (coreCount - cnt + selectedCnt < maxCore) return;

        findMax(cnt + 1, selectedCnt);

        for (int j = 1; j <= 4; j++) {
            boolean canDraw = canConnect(cnt, j);
            if (!canDraw) continue;
            setWire(cnt, j, true);
            used[cnt] = true;
            findMax(cnt + 1, selectedCnt + 1);
            used[cnt] = false;
            setWire(cnt, j, false);
        }
    }

    static boolean canConnect(int idx, int d) {
        int[] cur = cores.get(idx);
        int nx = cur[0], ny = cur[1];
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            if (arr[nx][ny] == 1 || visited[nx][ny]) return false;
        }
        return true;
    }

    static int setWire(int idx, int d, boolean state) {
        int[] cur = cores.get(idx);
        int nx = cur[0], ny = cur[1];
        int count = 0;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
            visited[nx][ny] = state;
            count++;
        }
        return count;
    }


    static int getWireLength() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) sum++;
            }
        }
        return sum;
    }
}