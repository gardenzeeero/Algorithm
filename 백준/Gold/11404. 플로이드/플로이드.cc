#include <bits/stdc++.h>
using namespace std;



int n, m;
int a, b, c;
int INF = 0x3f3f3f3f;
int arr[101][101];

int main(){
    cin >> n >> m;

    for(int i=1; i<=n; i++){
        fill(arr[i], arr[i]+1+n, INF);
        arr[i][i] = 0;
    }
    


    for(int i=0; i<m; i++){
        cin >> a >> b >> c;
        arr[a][b] = min(arr[a][b], c);
    }


    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            for(int k=1; k<=n; k++){
                arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k]);
            }
        }
    }


    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            if(arr[i][j] == INF) cout << 0 << " ";
            else cout << arr[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
