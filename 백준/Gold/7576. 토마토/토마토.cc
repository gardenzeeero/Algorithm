#include <iostream>
#include <queue>
#include <sstream>
#include <algorithm>
using namespace std;


int r, c, input;
int arr[1000][1000];
int dirX[4] = {-1, 0, 1, 0};
int dirY[4] = {0, -1, 0, 1};
queue<pair<int, int> > q;

int main(){

    cin >> c >> r;
    int count1 = 0, count2 = 0, result = 0;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> input;
            if(input == 1){
                q.push(pair<int, int>(i, j));
                count1++;
            }
            arr[i][j] = input;
        }
    }

    pair<int, int> cur;
    while(!q.empty()){
        if(count1 == 0){
            count1 = count2;
            count2 = 0;
            result++;
        }

        cur = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int nextX = cur.first + dirX[i], nextY = cur.second + dirY[i];
            if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue;
            if(arr[nextX][nextY] == 1 || arr[nextX][nextY] == -1) continue;
            arr[nextX][nextY] = 1;
            q.push(pair<int, int>(nextX, nextY));
            count2++;
        }
        count1--;
    }


    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            if(arr[i][j] == 0){
                cout << -1;
                return 0;
            }
        }
    }

    cout << result;


    return 0;
}
