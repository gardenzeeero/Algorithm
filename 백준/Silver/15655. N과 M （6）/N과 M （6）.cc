//11분

#include <bits/stdc++.h>
using namespace std;

int n, m, input;
vector<int> v;
vector<bool> isused;
vector<int> result;

void recursive(int count, int start){
    if(count == m){
        for(int i=0; i<m; i++){
            cout << result[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i=start; i<n; i++){
        if(!isused[i]){
            isused[i] = true;
            result[count] = v[i];
            recursive(count+1, i);
            isused[i] = false;
        }
    }

}

int main(){
    cin >> n >> m;

    for(int i=0; i<n; i++){
        cin >> input;
        v.push_back(input);
        isused.push_back(false);
        result.push_back(input);
    }

    sort(v.begin(), v.end());

    recursive(0, 0);

    return 0;
}