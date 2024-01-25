#include <iostream>
#include <queue>
#include <sstream>
#include <algorithm>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int tc;
    cin >> tc;

    int student, cur, nxt, result;
    int arr[100001];
    int visited[100001];

    queue<int> q;
    while(tc--){
        cin >> student;
        for(int i=1; i<=student; i++){
            cin >> arr[i];
            visited[i] = false;
        }


        result = 0;
        vector<int> isTeam;
        for(int i=1; i<=student; i++){
            if(visited[i]) continue;

            q.push(i);
            cur = i;
            while(true){
                isTeam.push_back(cur);
                visited[cur] = true;
                nxt = arr[cur];
                if(visited[nxt]) break;
                cur = nxt;
            }

            int idx = -1;
            for(int j=0; j<isTeam.size(); j++){
                if(nxt == isTeam[j]) {
                    idx = j;
                    break;
                }
            }

            if(idx == -1){
                result += isTeam.size();
            }else{
                result += idx;
            }
            isTeam.clear();
        }

        cout << result << "\n";
    }
}
