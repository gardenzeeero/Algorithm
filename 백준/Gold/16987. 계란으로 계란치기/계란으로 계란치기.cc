#include <bits/stdc++.h>
using namespace std;
#define s first
#define w second

pair<int, int> arr[8];
bool isused[8] = {false, };
int n;
int result = 0;

int check(){
    int temp = 0;
    for(int i=0; i<n; i++){
        if(arr[i].s <= 0){ 
            temp++;
        }
    }
    return temp;
}

void recursive(int count){
    bool flag = false;
    if(count == n){
        result = max(result, check());
        return;
    }
    if(arr[count].s <= 0){
        recursive(count+1);
    }else{
        for(int i=0; i<n; i++){
            if(arr[i].s > 0 && i != count){
                arr[count].s -= arr[i].w;
                arr[i].s -= arr[count].w;
                recursive(count+1);
                arr[count].s += arr[i].w;
                arr[i].s += arr[count].w;
                flag = true;
            }
        }
        if(!flag){
            recursive(count+1);
        }
    }
}

int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> arr[i].s >> arr[i].w;
    }

    recursive(0);

    cout << result;
    return 0;
}