#include <iostream>
#include <queue>
using namespace std;

int dirX[4] = {-1, 0, 1, 0};
int dirY[4] = {0, -1, 0 ,1};
int r, c;
int dist1[1001][1001];
int dist2[1001][1001];
char arr[1001][1001];


int main(){
    cin >> r >> c;

    char input;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> input;
            arr[i][j] = input;
            dist1[i][j] = -1;
            dist2[i][j] = -1;
        }
    }

    queue<pair<int, int> > q1, q2;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(arr[i][j] == 'F'){
                dist1[i][j] = 0;
                q1.push(pair<int, int>(i, j));
            }
            if(arr[i][j] == 'J'){
                dist2[i][j] = 0;
                q2.push(pair<int, int>(i, j));
            }
        }
    }

    pair<int, int> cur;
    int nextX, nextY;

    while(!q1.empty()){
        cur = q1.front(); q1.pop();
        for(int i=0; i<4; i++){
            nextX = cur.first + dirX[i]; nextY = cur.second + dirY[i];
            if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;
            if(arr[nextX][nextY] == '#' || dist1[nextX][nextY] >= 0) continue;
            dist1[nextX][nextY] = dist1[cur.first][cur.second] + 1;
            q1.push(pair<int, int>(nextX, nextY));
        }
    }


    while(!q2.empty()){
        cur = q2.front(); q2.pop();
        for(int i=0; i<4; i++){
            nextX = cur.first + dirX[i]; nextY = cur.second + dirY[i];
            if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c){
                cout << dist2[cur.first][cur.second] + 1;
                return 0;
            }
            if(arr[nextX][nextY] == '#' || dist2[nextX][nextY] >= 0) continue;
            if(dist1[nextX][nextY] != -1 && dist1[nextX][nextY] <= dist2[cur.first][cur.second] + 1) continue;
            dist2[nextX][nextY] = dist2[cur.first][cur.second] + 1;
            q2.push(pair<int, int>(nextX, nextY));
        }
    }

    cout << "IMPOSSIBLE";

    return 0;
}