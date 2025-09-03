import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] arr;
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
        int sx, sy;

        public Node(int sx, int sy) {
            this.sx = sx;
            this.sy = sy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
                minNum = Math.min(minNum, input[j]);
                maxNum = Math.max(maxNum, input[j]);
            }
        }

        int left = 0;
        int right = maxNum - minNum;

        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;

            boolean flag = false;
            for (int i = minNum; i + mid <= maxNum; i++) {
                if (canGo(i, i + mid)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    static boolean canGo(int minLimit, int maxLimit) {
        if (arr[0][0] < minLimit || arr[0][0] > maxLimit) return false;

        boolean[][] visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.sx + dx[i];
                int ny = cur.sy + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] < minLimit || arr[nx][ny] > maxLimit) continue;

                if (nx == n - 1 && ny == n - 1) return true;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

        return false;
    }

}
