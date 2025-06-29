import java.util.*;

class Solution {
    
    HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
    
    public int[] solution(int[] nodes, int[][] edges) {
        
        int[] answer = new int[2];
        
        for (int node : nodes) {
            edgeMap.put(node, new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        
        
        Set<Integer> visited = new HashSet<>();
        
        for (int node : nodes) {
            if (visited.contains(node)) continue;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            visited.add(node);
            
            int sameCount = 0;
            int diffCount = 0;
            
            while(!q.isEmpty()) {
                int current = q.poll();
                
                if (current%2 == edgeMap.get(current).size()%2) sameCount++;
                else diffCount++;
                
                for (int next : edgeMap.get(current)) {
                    if (visited.contains(next)) continue;
                    q.add(next);
                    visited.add(next);
                }
            }
            
            if (sameCount == 1) answer[0]++;
            if (diffCount == 1) answer[1]++;
        }
        
        return answer;
    }
}