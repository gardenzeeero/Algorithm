import java.util.*;

class Solution {
    int[][] path;
    
    public int solution(int m, int n, int[][] cityMap) {
        
        int[][] newCityMap = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                newCityMap[i][j] = cityMap[i-1][j-1];
            }
        }
        
        
        path = new int[m+1][n+1];
        path[1][1] = 1;
        
        int lx, ly, ux, uy;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (newCityMap[i][j] == 1) continue;
                
                lx = i; ly = j-1; ux = i-1; uy = j;
            
                while (newCityMap[ux][uy] == 2) {
                    ux--;
                    if (ux == 0) break;
                }
                while (newCityMap[lx][ly] == 2)  {
                    ly--;
                    if (ly == 0) break;
                }
                
                int upPath = path[ux][uy];
                int leftPath = path[lx][ly];
                
                path[i][j] += (upPath + leftPath) % 20170805;
            }
        }
        
        return path[m][n];
    }

}