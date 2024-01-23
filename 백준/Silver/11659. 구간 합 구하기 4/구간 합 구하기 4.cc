#include <bits/stdc++.h>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    vector<int> v;
    v.push_back(0);
    int n, m;
    cin >> n >> m;
    for(int i=0; i<n; i++){
        int input;
        cin >> input;
        v.push_back(v[v.size()-1] + input);
    }

    int i, j;
    for(int k=0; k<m; k++){
        cin >> i >> j;
        cout << v[j] - v[i-1] << "\n";
    }
}