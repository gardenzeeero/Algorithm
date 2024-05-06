//17분

#include <bits/stdc++.h>
using namespace std;

int n;
char arr[64][64];

bool check(int sx, int sy, int len){
    int temp = arr[sx][sy];
    for(int i=sx; i<sx+len; i++){
        for(int j=sy; j<sy+len; j++){
            if(temp != arr[i][j]) return false;
        }
    }
    return true;
}

void recursive(int sx, int sy, int len){
    if(len == 1){
        cout << arr[sx][sy];
        return;
    }
    if(!check(sx, sy, len)){
        cout << "(";
        recursive(sx, sy, len/2);
        recursive(sx, sy+len/2, len/2);
        recursive(sx+len/2, sy, len/2);
        recursive(sx+len/2, sy+len/2, len/2);
        cout << ")";
    }else{
        cout << arr[sx][sy];
    }
}


int main(){
    cin >> n;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> arr[i][j];
        }
    }

    recursive(0, 0, n);

    return 0;
}