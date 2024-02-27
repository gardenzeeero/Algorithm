// 5분

#include <bits/stdc++.h>
using namespace std;

int n, m, input;
vector<int> v;
vector<int> result;
vector<bool> isused;
string temp;
vector<string> check;


void recursive(int count){
    if(count == m){
        for(int i=0; i<m; i++){
            cout << result[i] << " ";
            
        }
        cout << "\n";
        return;
    }

    int cur = 0;
    for(int i=0; i<n; i++){
        if(!isused[i] && cur != v[i]){
            isused[i] = true;
            cur = result[count] = v[i]; 
            recursive(count+1);
            isused[i] = false;
        }
    }
}



int main(){
    cin >> n >> m;
    result.resize(n, 0);
    temp.resize(m, 0);

    for(int i=0; i<n; i++){
        cin >> input;
        v.push_back(input);
        isused.push_back(false);
    }

    sort(v.begin(), v.end());

    recursive(0);

    return 0;
}