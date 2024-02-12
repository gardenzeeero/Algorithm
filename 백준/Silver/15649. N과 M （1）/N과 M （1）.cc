#include <bits/stdc++.h>
using namespace std;



int m, n;
bool isused[9] = {false, };
int arr[9];
int k=1;

void recursive(int count){
    if(count == m){
        for(int i=0; i<m; i++) cout << arr[i] << " ";
        cout << "\n";
    }
    for(int i=1; i<=n; i++){
        if(!isused[i]){
            arr[count] = i;
            isused[i] = true;
            recursive(count + 1);
            isused[i] = false;
        }
    }
}


int main(){
    cin >> n >> m;

    

    recursive(0);

    return 0;
}