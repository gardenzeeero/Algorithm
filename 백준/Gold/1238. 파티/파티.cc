#include <bits/stdc++.h>
using namespace std;

int n, m, x;
int st, en, cost;
int arr[1001][1001];
int INF = 0x3f3f3f3f;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL);

    cin >> n >> m >> x;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(i == j) arr[i][j] = 0;
            else arr[i][j] = INF;
        }
    }

    for(int i=0; i<m; i++){
        cin >> st >> en >> cost;
        arr[st][en] = cost;
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            for(int k=1; k<=n; k++){
                if(arr[j][k] > arr[j][i] + arr[i][k])
                    arr[j][k] =  arr[j][i] + arr[i][k];
            }
        }
    }

    int result = -1;
    for(int i=1; i<=n; i++){
        result = max(result, arr[i][x] + arr[x][i]);
    }

    cout << result;
    

    return 0;
}