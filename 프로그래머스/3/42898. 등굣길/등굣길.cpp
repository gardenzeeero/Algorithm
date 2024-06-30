#include <bits/stdc++.h>
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    long long dp[101][101] = {0, };
    bool isWater[101][101] = {false, };
    
    for(int i=0; i<puddles.size(); i++){
        isWater[puddles[i][1]][puddles[i][0]] = true;
    }
    
    dp[1][1] = 1;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            if(isWater[i][j]) dp[i][j] = 0;
            else if(i == 1 && j == 1) continue;
            else if(i == 1 || j == 1) dp[i][j] = i == 1 ? dp[i][j-1] : dp[i-1][j];
            else dp[i][j] = dp[i-1][j] % 1000000007 + dp[i][j-1] % 1000000007;
        }
    }
    
    long long answer = dp[n][m] % 1000000007;
    
    return answer;
}