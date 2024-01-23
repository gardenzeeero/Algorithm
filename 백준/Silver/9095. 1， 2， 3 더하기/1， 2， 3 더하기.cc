#include <bits/stdc++.h>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int n;
    cin >> n;
    int arr[11] = {0, };
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for(int i=4; i<11; i++){
        int c = 0;
        for(int j=1; j<=3; j++){
            c+=arr[i-j];
        }
        arr[i] = c;
    }

    for(int i=0; i<n; i++){
        int input;
        cin >> input;
        cout << arr[input] << "\n";
    }

    return 0;

}