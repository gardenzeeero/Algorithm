#include <bits/stdc++.h>
#include <tuple>
using namespace std;



int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    vector<vector<int> > v;
    int computer, p;
    cin >> computer >> p;

    for(int i=0; i<=computer; i++){
        vector<int> temp;
        v.push_back(temp);
    }

    for(int i=0; i<p; i++){
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    bool visited[101] = {false, };
    queue<int> q;
    q.push(1);
    visited[1] = true;
    int count = 0;

    while(!q.empty()){
        int cur = q.front(); q.pop();
        for(int i=0; i<v[cur].size(); i++){
            int n = v[cur][i];
            if(visited[n]) continue;
            visited[n] = true;
            q.push(n);
            count++;
        }
    }

    cout << count;
    return 0;

}