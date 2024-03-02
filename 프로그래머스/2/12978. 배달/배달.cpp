#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> vec[51];
priority_queue<pair<int,int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int d[51];
int INF = 0x3f3f3f3f;

int solution(int N, vector<vector<int> > road, int K) {
    fill(d, d+N+1, INF);
    for(int i=0; i<road.size(); i++){
        vec[road[i][0]].push_back({road[i][2], road[i][1]});
        vec[road[i][1]].push_back({road[i][2], road[i][0]});
    }
    
    pq.push({0, 1});
    d[1] = 0;
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : vec[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second], nxt.second});
        }
    }
    
    int c=0;
    for(int i=1; i<=N; i++){
        if(d[i] <= K) c++;
    }
    
    return c;
    
}