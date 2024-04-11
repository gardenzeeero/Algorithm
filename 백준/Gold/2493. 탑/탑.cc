//10분

#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, input;
    cin >> n;
    
    vector<pair<int, int> > v;

    for(int i=1; i<=n; i++){
        cin >> input;
        while(!v.empty()){
            if(v.back().first < input) v.pop_back();
            else break;
        }

        if(v.empty()) cout << 0 << " ";
        else cout << v.back().second << " ";

        v.push_back({input, i});
    }

    return 0;
}