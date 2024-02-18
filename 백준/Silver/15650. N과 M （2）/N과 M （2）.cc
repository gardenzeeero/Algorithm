#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];
bool isused[8] = {false, }; 

void recursive(int count, int start){
    if(count == m){
        for(int i=0; i<m; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=start; i<n; i++){
        if(!isused[i]){
            isused[i] = true;
            arr[count] = i+1;
            recursive(count+1, i+1);
            isused[i] = false;
        }
    }
}


int main(){
    cin >> n >> m;

    recursive(0, 0);

    return 0;
}
