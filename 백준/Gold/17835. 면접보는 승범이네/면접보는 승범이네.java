import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int num;
        long dist;

        public Edge(int num, long dist) {
            this.num = num; this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.dist, e.dist);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = arr[0], m = arr[1], k = arr[2];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Map<Integer, ArrayList<Edge>> map = new HashMap<>();

        for(int i=1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            //도착지에서 출발지로 갈꺼니 반대로
            int st = edge[1], end = edge[0], dist = edge[2];
            map.get(st).add(new Edge(end, dist));
        }

        int[] meet = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        long[] distance = new long[n+1];
        boolean[] isVisited = new boolean[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        for(int i=0; i<k; i++) {
            distance[meet[i]] = 0;
            pq.add(new Edge(meet[i], 0));
        }

        //pqEdge의 num은 시작점, e의 num은 도착점
        while(!pq.isEmpty()) {
            Edge pqEdge = pq.poll();
            if(pqEdge.dist != distance[pqEdge.num]) continue;

            for(Edge e : map.get(pqEdge.num)) {
                if(distance[e.num] <= e.dist + pqEdge.dist) continue;
                distance[e.num] = e.dist + pqEdge.dist;
                pq.add(new Edge(e.num, distance[e.num]));
            }
        }

        long resultDist = -1;
        int resultNum = 0;
        for(int i=1; i<=n; i++) {
            if(distance[i] > resultDist) {
                resultNum = i;
                resultDist = distance[i];
            }
        }

        System.out.println(resultNum);
        System.out.println(resultDist);
    }
}
