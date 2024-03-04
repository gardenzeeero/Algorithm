#include <bits/stdc++.h>
using namespace std;

int main(){
    long long int k, input;

    cin >> k;
    
    vector<long long int> v;
    while(k--){
        cin >> input;
        if(input == 0){
            v.pop_back();
        }else{
            v.push_back(input);
        }
    }

    int sum=0;
    for(int i=0; i<v.size(); i++){
        sum += v[i];
    }

    cout << sum;

    return 0;
}