 #include <bits/stdc++.h>
using namespace std;
int dist[501];
map<pair<int, int>, int> road;
int tc, n, m, w, s, e, t;
int INF = 0x7f7f7f7f;

bool belman(int start){
    fill(dist + 1, dist + n + 1, INF);
    dist[start] = 0;

    int tempStart, tempEnd, tempTime;
    for(int i=0; i<n-1; i++){
        bool updated = false;
        for(auto val : road){
            tempStart = val.first.first; tempEnd = val.first.second; tempTime = val.second;
            
            if(dist[tempStart] == INF) continue;
            if(dist[tempStart] + tempTime < dist[tempEnd]) {
                dist[tempEnd] = dist[tempStart] + tempTime;
                updated = true;
            }
        }
        if(!updated) break;
    }

    bool flag = false;
    for(auto val : road){
        tempStart = val.first.first; tempEnd = val.first.second; tempTime = val.second;

        if(dist[tempStart] == INF) continue;
        if(dist[tempStart] + tempTime < dist[tempEnd]) flag = true;
    }

    return flag;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> tc;
    while(tc--){
        cin >> n >> m >> w;

        //입력받아 양방향으로 저장, 더 짧은 경로가 나오면 업데이트
        for(int i=0; i<m; i++){
            cin >> s >> e >> t;
            auto it = road.find({s, e});
            if(it != road.end() && (*it).second < t) continue;
            road[{s, e}] = t; road[{e, s}] = t;
        }

        //웜홀은 단방향 음수간선으로 받기
        for(int i=0; i<w; i++){
            cin >> s >> e >> t;
            t = -t;
            auto it = road.find({s, e});
            if(it != road.end() && (*it).second < t) continue;
            road[{s, e}] = t;
        }

        //음수 사이클이 있는지 파악
        bool flag = false;
        for(int i=1; i<=n; i++){
            if(belman(i)){
                flag = true;
                break;
            }
        }

        if(flag) cout << "YES" << "\n";
        else cout << "NO" << "\n";

        road.clear();
    }

    return 0;
}