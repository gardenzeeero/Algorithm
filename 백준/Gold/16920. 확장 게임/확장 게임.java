//제발 지문 수정좀 하라고;;
import java.io.*;
import java.util.*;

class Node {
    char p;
    int x, y;

    public Node(char p, int x, int y) {
        this.p = p;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static int n, m, p;
    private static char[][] arr;
    private static int[] distance;
    private static LinkedList<Node>[] sq;
    private static boolean flag;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        distance = new int[p+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=p; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        String input;
        arr = new char[n][m];
        sq = new LinkedList[p+1];
        for(int i=1; i<=p; i++) sq[i] = new LinkedList<>();

        for(int i=0; i<n; i++) {
            input = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = input.charAt(j);
                if('1' <= arr[i][j] && arr[i][j] <= '9') sq[arr[i][j] - '0'].add(new Node(arr[i][j], i, j));
            }
        }

        while (!flag) {
            flag = true;
            for(int i=1; i<=p; i++){
                bfs(sq[i], distance[i]);
            }
        }

        int[] result = new int[26];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if('1' <= arr[i][j] && arr[i][j] <= '9') result[arr[i][j] - '0']++;
            }
        }

        for(int i=1; i<=p; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static void bfs(LinkedList<Node> q, int count) {

        LinkedList<Node> bq = new LinkedList<>(q);
        q.clear();


        int start = 0;
        while(!bq.isEmpty()) {
            int qSize = bq.size();
            start++;

            for(int i=0; i<qSize; i++){
                Node cn = bq.poll();

                for(int j=0; j<4; j++) {
                    int nx = cn.x + dx[j], ny = cn.y + dy[j];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(arr[nx][ny] != '.') continue;
                    arr[nx][ny] = cn.p;

                    if(start == count) {
                        flag = false;
                        q.add(new Node(cn.p, nx, ny));
                    }else{
                        bq.add(new Node(cn.p, nx, ny));
                    }
                }
            }

            if(start == count) break;
        }
    }
}