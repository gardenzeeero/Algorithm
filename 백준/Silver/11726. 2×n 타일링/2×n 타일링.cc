#include <bits/stdc++.h>
using namespace std;



int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int n;
    cin >> n;

    long long int arr[1001] = {0, };
    arr[1] = 1;
    arr[2] = 2;
    for(int i=3; i<=n; i++){
        long long int temp = 0;
        for(int j=1; j<=2; j++){
            temp += arr[i-j];
        }
        temp %= 10007;
        arr[i] = temp;

    }

    cout << arr[n];
}