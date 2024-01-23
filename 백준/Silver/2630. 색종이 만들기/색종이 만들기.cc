#include <bits/stdc++.h>
using namespace std;


int arr[129][129];

int white = 0;
int blue = 0;

void check(int sX, int sY, int eX, int eY){
    int row = eX - sX + 1;
    int a = arr[sX][sY];
    bool sign = false;
    for(int i=sX; i<=eX; i++){
        if(sign) break;
        for(int j=sY; j<=eY; j++){
            if(arr[i][j] != a){
                sign = true;
                break;
            }
        }
    }

    if(!sign || (sX == eX && sY == eY)){
        if(a == 0){
            white++;
        }else{
            blue++;
        }
    }else{
        check(sX, sY, eX-row/2, eY-row/2);
        check(sX, sY+row/2, eX-row/2, eY);
        check(sX+row/2, sY, eX, eY-row/2);
        check(sX+row/2, sY+row/2, eX, eY);
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int n;
    cin >> n;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            int input;
            cin >> input;
            arr[i][j] = input;
        }
    }

    check(1, 1, n, n);

    cout << white << "\n" << blue;

    return 0;

}