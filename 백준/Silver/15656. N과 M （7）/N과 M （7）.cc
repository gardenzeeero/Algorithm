//7분

#include <bits/stdc++.h>
using namespace std;

int n, m, input;
vector<int> v;
vector<int> result;

void recursive(int count){
    if(count == m){
        for(int i=0; i<m; i++){
           cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i=0; i<n; i++){
        result[count] = v[i];
        recursive(count+1);
    }
}

int main(){
    cin >> n >> m;
    result.resize(n, 0);

    for(int i=0; i<n; i++){
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end());

    recursive(0);

    return 0;
}