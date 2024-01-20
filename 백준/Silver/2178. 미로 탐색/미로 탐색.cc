#include <iostream>
#include <queue>
#include <sstream>
#include <algorithm>
using namespace std;

int arr[100][100];
int dist[100][100];
int r, c;
queue<pair<int, int> > q;
int dirX[4] = {-1, 0, 1, 0};
int dirY[4] = {0, -1, 0, 1};

int main(){
    cin >> r >> c;

    string str;
    for(int i=0; i<r; i++){
        cin >> str;
        for(int j=0; j<c; j++){
            arr[i][j] = str[j]-'0';
            dist[i][j] = -1;
        }
    }

    pair<int, int> cur;
    queue<pair<int, int> > q;
    q.push(pair<int, int>(0, 0));
    dist[0][0] = 1;
    while(!q.empty()){
        cur = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int nextX = cur.first + dirX[i], nextY = cur.second + dirY[i];
            if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;
            if(arr[nextX][nextY] < 1 || dist[nextX][nextY] > -1) continue;
            dist[nextX][nextY] = dist[cur.first][cur.second] + 1;
            q.push(pair<int, int>(nextX, nextY));
        }
    }

    cout << dist[r-1][c-1];
    
    return 0;
}