#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int a, b, c;
    vector<int> v;
    while(true){
        cin >> a >> b >> c;
        v.push_back(a); v.push_back(b); v.push_back(c);
        sort(v.begin(), v.end());
        if(a == 0 && b == 0 && c == 0) break;

        if(v[0]*v[0] + v[1]*v[1] == v[2]*v[2]){
            cout << "right" << '\n';
        }else{
            cout << "wrong" << "\n";
        }
        v.clear();
    }

}