#include <iostream>
#include <queue>
using namespace std;

char arr[51][51];

int check(int a, int b){
    int count1 = 0, count2 = 0 ;
    bool toggle = false;
    for(int i=a; i<a+8; i++){
        for(int j=b; j<b+8; j++){
            if(!toggle){
                if(arr[i][j] != 'W') count1++;
                toggle = !toggle;
            }else{
                if(arr[i][j] != 'B') count1++;
                toggle = !toggle;
            }
        }
        toggle = !toggle;
    }

    toggle = false;
    for(int i=a; i<a+8; i++){
        for(int j=b; j<b+8; j++){
            if(!toggle){
                if(arr[i][j] != 'B') count2++;
                toggle = !toggle;
            }else{
                if(arr[i][j] != 'W') count2++;
                toggle = !toggle;
            }
        }
        toggle = !toggle;
    }

    return count1 > count2 ? count2 : count1;
}

int main(){
    int r, c;
    cin >> r >> c;

    char input;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cin >> input;
            arr[i][j] = input;
        }
    }

    int min = 1000000;
    int count;
    for(int i=0; i<=r-8; i++){
        for(int j=0; j<=c-8; j++){
            count = check(i, j);
            if(count < min) min = count;
        }
    }

    cout << min;

    return 0;
}