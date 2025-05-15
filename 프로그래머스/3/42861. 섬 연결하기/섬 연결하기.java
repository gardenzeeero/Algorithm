import java.util.*;

class Solution {
    
    int[] parent;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    
    class Edge implements Comparable<Edge> {
        int st, end, cost;
        public Edge(int st, int end, int cost) {
            this.st = st; this.end = end; this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
        
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i=0; i<n; i++) parent[i] = i;
        
        for (int i=0; i<costs.length; i++) {
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int stParent = find(now.st); int endParent = find(now.end);
            
            if (stParent == endParent) continue;
            parent[endParent] = stParent;
            answer += now.cost;
        }
    
        return answer;
    }
    
    public int find(int node) {
        int parentNode = parent[node];
        while(parentNode != node) {
            node = parentNode;
            parentNode = parent[node];
        }
        
        return parentNode;
    }
}