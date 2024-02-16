#include <bits/stdc++.h>
using namespace std;


int n, s;
int arr[20];
int result = 0, sum = 0;
int check = 0;

void recursive(int count){
    if(count == n){
        if(sum == s && check != 0) result++;
        return;
    }
    recursive(count+1);

    sum += arr[count];
    check++;
    recursive(count+1);
    sum -= arr[count];
    check--;
}


int main(){
    cin >> n >> s;

    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    recursive(0);

    cout << result;

    return 0;
}