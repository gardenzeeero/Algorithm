#include <bits/stdc++.h>
using namespace std;



int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    int arr[1001][1001];
    int dist[1001][1001];
    int dirX[4] = {-1, 0, 1, 0};
    int dirY[4] = {0, -1, 0 ,1};

    int input;
    int tx, ty;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> input;
            if(input == 2){
                tx = i;
                ty = j;
            }
            arr[i][j] = input;
            dist[i][j] = -1;
            if(input == 0){
                dist[i][j] = 0;
            }
        }
    }

    queue<pair<int, int> > q;
    q.push(pair<int, int>(tx, ty));
    dist[tx][ty] = 0;
    pair<int, int> cur;
    while(!q.empty()){
        cur = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int nx = cur.first + dirX[i], ny = cur.second + dirY[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(arr[nx][ny] == 0 || dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[cur.first][cur.second] + 1;
            q.push(pair<int, int>(nx, ny));
        }
    }

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cout << dist[i][j] << " ";
        }
        cout << "\n";
    }


}