#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n, m, k;
string arr[1000];
int dist[1000][1000][11];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> n >> m >> k;

    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    queue<tuple<int, int, int>> q;
    q.push({0, 0, 0});
    dist[0][0][0] = 1;
    while(!q.empty()){
        int b, x, y;
        tie(b, x, y) = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            int crash = b + (arr[nx][ny] - '0');
            if(dist[nx][ny][crash] > 0 || crash > k) continue;
            dist[nx][ny][crash] = dist[x][y][b] + 1;
            q.push({crash, nx, ny});
        }
    }

    int result = 987654321;
    for(int i=0; i<=k; i++){
        if(dist[n-1][m-1][i] != 0) result = min(result, dist[n-1][m-1][i]);
    }

    if(result == 987654321) cout << -1;
    else cout << result;


    return 0;
}