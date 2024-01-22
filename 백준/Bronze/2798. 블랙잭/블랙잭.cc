#include <bits/stdc++.h>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n, m;
    cin >> n >> m;
    int max = -1;

    int arr[101];
    for(int i=0; i<n; i++){
        int input;
        cin >> input;
        arr[i] = input;
    }
    for(int i=0; i<n-2; i++){
        for(int j=i+1; j<n-1; j++){
            for(int k=j+1; k<n; k++){
                int temp = arr[i] + arr[j] + arr[k];
                if(temp <= m && temp > max) max = temp;
            }
        }
    }

    cout << max;
}