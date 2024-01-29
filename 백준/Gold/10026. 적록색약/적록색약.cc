#include <iostream>
#include <queue>
#include <sstream>
#include <algorithm>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    char arr[100][100];
    bool visited[100][100];
    int dirX[4] = {-1, 0, 1, 0};
    int dirY[4] = {0, -1, 0, 1};

    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> arr[i][j];
            visited[i][j] = false;
        }
    }

    int result = 0;
    for(int j=0; j<n; j++){
        for(int k=0; k<n; k++){
            queue<pair<int, int> > q;
            bool check = false;
            if(!visited[j][k]){
                q.push(pair<int, int>(j, k));
                visited[j][k] = true;
                check = true;
            }
            while(!q.empty()){
                pair<int, int> cur = q.front(); q.pop();
                for(int i=0; i<4; i++){
                    int nx = cur.first + dirX[i], ny = cur.second + dirY[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visited[nx][ny] || arr[nx][ny] != arr[cur.first][cur.second]) continue;
                    visited[nx][ny] = true;
                    q.push(pair<int, int>(nx, ny));
                }
            }
            if(check){
                result++;
            }
        }
    }

    cout << result << " ";

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(arr[i][j] == 'G') arr[i][j] = 'R';
            visited[i][j] = false;
        }
    }

    result = 0;
    for(int j=0; j<n; j++){
        for(int k=0; k<n; k++){
            queue<pair<int, int> > q;
            bool check = false;
            if(!visited[j][k]){
                q.push(pair<int, int>(j, k));
                visited[j][k] = true;
                check = true;
            }
            while(!q.empty()){
                pair<int, int> cur = q.front(); q.pop();
                for(int i=0; i<4; i++){
                    int nx = cur.first + dirX[i], ny = cur.second + dirY[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visited[nx][ny] || arr[nx][ny] != arr[cur.first][cur.second]) continue;
                    visited[nx][ny] = true;
                    q.push(pair<int, int>(nx, ny));
                }
            }
            if(check){
                result++;
            }
        }
    }

    cout << result;


}
