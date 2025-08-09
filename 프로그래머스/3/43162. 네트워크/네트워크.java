import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        
        int answer = 0;
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            BFS(n, i, computers);
            answer++;
            
        }
        
        return answer;
    }
    
    public void BFS(int n, int st, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
    
        q.add(st);
        visited[st] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i=0; i<n; i++) {
                if (visited[i]) continue;
                if (computers[now][i] == 0) continue;
                q.add(i);
                visited[i] = true;
            }
        }
    }
}