class Solution {
    
    int[][] routeCount;
    boolean[][] isPuddle;
    public int solution(int m, int n, int[][] puddles) {
        
        routeCount = new int[m][n];
        isPuddle = new boolean[m][n];
        
        for (int i=0; i<puddles.length; i++) {
            isPuddle[puddles[i][0]-1][puddles[i][1]-1] = true;
        }
        
        
        routeCount[0][0] = 1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) continue;
                if (isPuddle[i][j]) continue;
                int up = 0;
                int left = 0;
                if (i != 0) up = routeCount[i-1][j];
                if (j != 0) left = routeCount[i][j-1];
                
                routeCount[i][j] = ((up + left) % 1000000007) % 1000000007;
            }
        }
        
        int answer = routeCount[m-1][n-1];
        return answer;
    }
}