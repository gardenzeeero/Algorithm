#include <bits/stdc++.h>
using namespace std;

int r, c;
char arr[21][21];
bool isUsed['Z'-'A' + 1];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int result;


void recursive(int x, int y, int count){
    result = max(result, count);
    
    int nx, ny;
    for(int i=0; i<4; i++){
        nx = x + dx[i]; ny = y + dy[i];
        if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
        if(isUsed[arr[nx][ny] - 'A']) continue;

        isUsed[arr[nx][ny] - 'A'] = true;
        recursive(nx, ny, count+1);
        isUsed[arr[nx][ny] - 'A'] = false;
    }

    

}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> r >> c;
    
    
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> arr[i][j];
        }
    }

    result = -1;
    isUsed[arr[0][0] - 'A'] = true;
    recursive(0, 0, 1);

    cout << result;

    return 0;
}