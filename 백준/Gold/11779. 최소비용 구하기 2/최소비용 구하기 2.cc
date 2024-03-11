#include <bits/stdc++.h>
using namespace std;

int n, m;
int st, en, cost;
vector<pair<int, int>> v[1001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int d[1001];
int pre[1001];
int INF = 0x3f3f3f3f;

int main(){
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> n >> m;

    for(int i=1; i<=n; i++) d[i] = INF;

    while(m--){
        cin >> st >> en >> cost;
        v[st].push_back({cost, en});
    }
    cin >> st >> en;

    d[st] = 0;
    pq.push({0, st});
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();

        if(cur.first != d[cur.second]) continue;
        for(auto nxt : v[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
            pre[nxt.second] = cur.second;
        }
    }

    cout << d[en] << "\n";
    
    vector<int> path;
    while(en != st){
        path.push_back(en);
        en = pre[en];
    }
    path.push_back(st);

    cout << path.size() << "\n";
    for(int i=path.size()-1; i >= 0; i--) cout << path[i] << " ";
    
    return 0;
}