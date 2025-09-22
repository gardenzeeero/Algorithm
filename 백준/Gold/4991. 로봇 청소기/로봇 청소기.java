import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.in;
import static java.util.Arrays.stream;


/**
 * 점이 총 400개 -> 400 * 200 조합 -> 80000개
 * 8만개를 최소 스패닝 트리로.
 * 근데 거리가 있을 땐 가능한데 거리가 없음 -> BFS로 구해야 함
 * 칸은 10개가 안넘는다 -> 10 * 9 /2 = 45개의 선분 존재 ->
 */
public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h, edgeCount, sIdx;
    static char[][] map;
    static ArrayList<Area> dirty = new ArrayList<>();
    static boolean[] visited;
    static int answer, dSize;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();

    static class Area {
        int x, y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int idx, cost;

        public Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int[] input;
        char[] cinput;
        while (true) {
            dirty.clear();
            edges = new ArrayList<>();
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            w = input[1];
            h = input[0];
            if (w == 0 && h == 0) break;

            map = new char[w][h];

            for (int i = 0; i < w; i++) {
                cinput = br.readLine().toCharArray();
                for (int j = 0; j < h; j++) {
                    map[i][j] = cinput[j];
                    if (map[i][j] == '*') {
                        dirty.add(new Area(i, j));
                    } else if (map[i][j] == 'o') {
                        dirty.add(new Area(i, j));
                        sIdx = dirty.size() - 1;
                    }
                }
            }

            edgeCount = 0;
            dSize = dirty.size();
            for (int i = 0; i < dSize; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < dSize; i++) {
                makeEdge(i, dirty.get(i));
            }

            if (edgeCount != (dSize - 1) * dSize) {
                System.out.println("-1");
                continue;
            }

            visited = new boolean[dSize];
            visited[sIdx] = true;
            answer = Integer.MAX_VALUE;
            dfs(sIdx, 1, 0);

            System.out.println(answer);
        }
    }

    static void dfs(int idx, int count, int cost) {
        if (count == dSize) {
            answer = Math.min(answer, cost);
            return;
        }

        visited[idx] = true;
        for (Edge e : edges.get(idx)) {
            if (visited[e.idx]) continue;
            if (cost + e.cost >= answer) continue;
            visited[e.idx] = true;
            dfs(e.idx, count + 1, cost + e.cost);
            visited[e.idx] = false;
        }
    }

    static void makeEdge(int stIdx, Area stArea) {
        int[][] dist = new int[w][h];
        Queue<Area> q = new LinkedList<>();
        q.add(stArea);
        dist[stArea.x][stArea.y] = 1;
        while (!q.isEmpty()) {
            Area cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if (map[nx][ny] == 'x') continue;
                if (dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Area(nx, ny));
            }
        }

        for (int i = 0; i < dSize; i++) {
            Area target = dirty.get(i);
            int d = dist[target.x][target.y];
            if (d == 0 || d == 1) continue;
            edges.get(stIdx).add(new Edge(i, d - 1));
            edges.get(i).add(new Edge(stIdx, d - 1));
            edgeCount++;
        }
    }
}
