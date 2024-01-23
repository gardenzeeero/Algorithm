#include <bits/stdc++.h>
#include <tuple>
using namespace std;

int arr[1000001];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int a;
    cin >> a;
    if(a == 1){
        cout << 0;
        return 0;
    }
    for(int i=0; i<=a; i++){
        arr[i] = -1;
    }

    queue<int> q;
    q.push(1);
    arr[1] = 0;
    while(!q.empty()){
        int cur = q.front(); q.pop();
        int temp[3] = {cur+1, cur*2, cur*3};
        for(int i=0 ; i<3; i++){
            int n = temp[i];
            if(n > a || arr[n] >= 0) continue;
            arr[n] = arr[cur]+1;
            if(n == a){
                cout << arr[n];
                return 0;
            }
            q.push(n);
        }
    }

    return 0;

}