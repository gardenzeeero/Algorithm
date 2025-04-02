import java.util.*;

class Solution {
    int[] info;
    ArrayList<ArrayList<Integer>> edges;
    int maxSheep = 1;
    
    class Node {
        int now, sheep, wolf;
        HashSet<Integer> adjacent = new HashSet<>();
        
        public Node(int now, int sheep, int wolf) {
            this.now = now; this.sheep = sheep; this.wolf = wolf;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        init(info, edges);
        
        Node root = new Node(0, 1, 0);
        for (int to : this.edges.get(0)) {
            root.adjacent.add(to);
        }
        
        dfs(root);
        
        return maxSheep;
    }
    
    public void dfs(Node cur) {
        
        for (int nextIdx : cur.adjacent) {
            if (cur.wolf + info[nextIdx] >= cur.sheep) continue;
            
            int plusSheep = info[nextIdx] == 0 ? 1 : 0;
            Node nextNode = new Node(nextIdx, cur.sheep + plusSheep, cur.wolf + info[nextIdx]);
            
            //갈 수 있는 곳 설정
            HashSet<Integer> nextAdjacent = new HashSet<>(cur.adjacent);
            for (int n : edges.get(nextIdx)){
                nextAdjacent.add(n);
            }
            nextAdjacent.remove(nextIdx);  //자신은 제외
            nextNode.adjacent = nextAdjacent;
            
            //양의 수 비교
            maxSheep = Math.max(maxSheep, nextNode.sheep);
            
            dfs(nextNode);
        }
    }
    
    public void init(int[] info, int[][] edges) {
        this.info = info;
        
        this.edges = new ArrayList<>();
        for (int i=0; i<info.length; i++) this.edges.add(new ArrayList<>());
        
        for (int i=0; i<edges.length; i++) this.edges.get(edges[i][0]).add(edges[i][1]);
    }
}