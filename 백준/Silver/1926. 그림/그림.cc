#include <iostream>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int arr[500][500];
bool visited[500][500];
int r, c;
queue<pair<int, int> > q;
int dirX[4] = {-1, 0, 1, 0};
int dirY[4] = {0, -1, 0, 1};

int main(){
    cin >> r >> c;

    int input;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> input;
            arr[i][j] = input;
        }
    }


    int mx = 0, num = 0;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(arr[i][j] == 0 || visited[i][j]) continue;
            q.push(pair<int, int>(i, j));
            visited[i][j] = true;
            num++;

            int area = 0;
            while(!q.empty()){
                area++;
                pair<int, int> cur = q.front(); q.pop();
                for(int i=0; i<4; i++){
                    int tempX = cur.first + dirX[i];
                    int tempY = cur.second + dirY[i];
                    if(tempX < 0 || tempX >= r || tempY < 0 || tempY >= c) continue;
                    if(arr[tempX][tempY] == 0 || visited[tempX][tempY]) continue;
                    visited[tempX][tempY] = true;
                    q.push(pair<int,int>(tempX,tempY));
                }
            }
            mx = max(mx, area);
        }
    }

    cout << num << "\n" << mx;
    return 0;
}
