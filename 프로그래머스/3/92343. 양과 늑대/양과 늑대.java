import java.io.*;
import java.util.*;

class Solution {
    
    static int result = 0;
    static int n;
    static int[] gInfo;
    static ArrayList<Integer>[] gEdges;
    
    
    public int solution(int[] info, int[][] edges) {
        
        gEdges = new ArrayList[info.length];
        for (int i=0; i<info.length; i++) {
            gEdges[i] = new ArrayList<Integer>();
        }
        n = info.length;
        gInfo = info;
        for (int i=0; i<edges.length; i++) {
            gEdges[(edges[i][0])].add(edges[i][1]);
        }
        
        dfs(0, new boolean[info.length], 1, 0);
        
        return result;
    }
    
    void dfs(int cur, boolean[] canGo, int sheep, int wolf) {
        result = Math.max(result, sheep);
        canGo[cur] = false;
        
        for (int next : gEdges[cur]) {
            canGo[next] = true;
        }
        
        for (int next=0; next<n; next++) {
            if (!canGo[next]) continue;
            
            if (gInfo[next] == 0) dfs(next, Arrays.copyOf(canGo, canGo.length), sheep+1, wolf);
            else if (gInfo[next] == 1 && (sheep > wolf + 1)) {
                dfs(next, Arrays.copyOf(canGo, canGo.length), sheep, wolf + 1);
            }
        }
    }
    
    
}