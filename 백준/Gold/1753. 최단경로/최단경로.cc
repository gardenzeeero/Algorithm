#include <bits/stdc++.h>
using namespace std;

int v, e, st;
int u, g, w;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
vector<pair<int, int>> vec[20001];
int d[20001];
int INF = 0x3f3f3f3f;

int main(){
    cin >> v >> e >> st;
    fill(d, d+v+1, INF);
    d[st] = 0;

    for(int i=1; i<=e; i++){
        cin >> u >> g >> w;
        vec[u].push_back({w, g});
    }

    pq.push({d[st], st});
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : vec[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
        }
    }

    for(int i=1; i<=v; i++){
        if(d[i] == INF) cout << "INF" << "\n";
        else cout << d[i] << "\n";
    }

    return 0;
}