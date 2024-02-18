#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];

void recursive(int count){
    if(count == m){
        for(int i=0; i<m; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=0; i<n; i++){
        arr[count] = i+1;
        recursive(count+1);
    }
}


int main(){
    cin >> n >> m;

    recursive(0);

    return 0;
}
