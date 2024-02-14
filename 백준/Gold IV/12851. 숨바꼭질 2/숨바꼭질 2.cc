#include <bits/stdc++.h>
using namespace std;

int n, k;
int result = 0;
int arr[200001];



int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> k;

    for(int i=0; i<200001; i++){
        arr[i] = -1;
    }
    
    arr[n] = 0;
    queue<int> q;
    q.push(n);
    int nx;
    while(!q.empty()){
        int cur = q.front(); q.pop();
        
        nx = cur - 1;
        if(nx >= 0 && (arr[nx] < 0 || arr[nx] == arr[cur]+1)){
            if(nx == k) result++;
            arr[nx] = arr[cur] + 1;
            q.push(nx);
        }

        nx = cur + 1;
        if(nx <= k && (arr[nx] < 0 || arr[nx] == arr[cur]+1)){
            if(nx == k) result++;
            arr[nx] = arr[cur] + 1;
            q.push(nx);
        }

        nx = cur * 2;
        if(nx <= 200000 && (arr[nx] < 0 || arr[nx] == arr[cur]+1)){
            if(nx == k) result++;
            arr[nx] = arr[cur] + 1;
            q.push(nx);
        }
        
    }
   
    cout << arr[k] << "\n";
    if(n == k){
        cout << 1;
    }else{
        cout << result;
    }
    


    return 0;
}