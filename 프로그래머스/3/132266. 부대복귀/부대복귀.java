import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> roadMap = new ArrayList<>();
    int gdestination;
    int gn;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        gn = n;
        gdestination = destination;
    
        for(int i=0; i<n; i++){
            roadMap.add(new ArrayList<>());
        }

        for(int i=0; i<roads.length; i++){
            int start = roads[i][0];
            int end = roads[i][1];
            
            roadMap.get(start-1).add(end-1);
            roadMap.get(end-1).add(start-1);
        }
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = bfs(sources[i]-1);
            if(sources[i]-1 == gdestination-1) answer[i] = 0;
        }
        
        return answer;
    }
    
    int bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[gn];
        
        queue.add(source);
        int result = 1;
        while(!queue.isEmpty()){
            int cycle = queue.size();
            for(int i=0; i<cycle; i++) {
                int start = queue.poll();
                if(visited[start]) continue;
                visited[start] = true;
                for(int end : roadMap.get(start)) {
                    if(end == gdestination-1) {
                        return result;
                    }
                    queue.offer(end);
                }
            }
            
            result++;
        }
        return -1;
    }
}