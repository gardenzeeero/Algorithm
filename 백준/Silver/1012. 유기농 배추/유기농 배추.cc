#include <bits/stdc++.h>
#include <tuple>
using namespace std;

int dirX[4] = {-1, 0, 1, 0};
int dirY[4] = {0, -1, 0 ,1};

int arr[51][51];
int m, n, zirong;


void BFS(int i, int j){
    queue<pair<int, int> > q;
    q.push(pair<int, int>(i, j));
    arr[i][j] = 0;

    pair<int, int> cur;
    while(!q.empty()){
        cur = q.front(); q.pop();
        for(int k=0; k<4; k++){
            int nx = cur.first + dirX[k];
            int ny = cur.second + dirY[k];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(arr[nx][ny] == 0) continue;
            arr[nx][ny] = 0;
            q.push(pair<int, int>(nx, ny));
        }
    }
}

int main(){

    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int tc;
    cin >> tc;

    while(tc--){
        cin >> n >> m >> zirong;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[n][m] = 0;
            }
        }
        int x, y;
        for(int i=0; i<zirong; i++){
            cin >> x >> y;
            arr[x][y] = 1;
        }

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        cout << count <<"\n";
    }




}