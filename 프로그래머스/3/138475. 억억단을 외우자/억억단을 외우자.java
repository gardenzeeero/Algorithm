import java.io.*;

class Solution {
    int[] countNum, dp;
    
    public int[] solution(int e, int[] starts) {    
        countNum = new int[e+1];
        
        
        for (int i=2; i<=e; i++) {
            int loop = e / i;
            for (int j=1; j<=loop; j++) {
                countNum[i * j]++;
            }
        }
        
        dp = new int[e+1];
        dp[e] = e;
        for (int i=e-1; i>=1; i--) {
            int prevMaxIdx = dp[i+1];
            if (countNum[i] >= countNum[prevMaxIdx]) dp[i] = i;
            else dp[i] = dp[i+1];
        }
    
        
        int[] result = new int[starts.length];
        for (int i=0; i<starts.length; i++) {
            result[i] = dp[starts[i]];
        }
        
        return result;
    }
}