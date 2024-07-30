#include <bits/stdc++.h>
using namespace std;

int n, m, bannedSize, input, child, parent;
int arr[51];
bool banned[51];
vector<vector<int>> party;

int find(int node){
    while(arr[node] != node){
        node = arr[node];
    }

    return node;
}

void merge(int par, int chd){
    par = find(par);
    chd = find(chd);

    if(par == chd) return;

    arr[chd] = par;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    cin >> n >> m;

    for(int i=1; i<=n; i++){
        arr[i] = i;
    }

    cin >> bannedSize;
    for(int i=0; i<bannedSize; i++){
        cin >> input;
        banned[input] = true;
    }

    for(int i=0; i<m; i++){
        cin >> input >> parent;
        vector<int> temp;
        temp.push_back(parent);

        for(int j=0; j<input-1; j++){
            cin >> child;
            temp.push_back(child);
            if(find(parent) != find(child)){
                merge(parent, child);
            }
        }

        party.push_back(temp);
    }

    for(int i=1; i<=n; i++){
        if(banned[i] == true){
            banned[find(i)] = true;
        }
    }


    int result = 0;
    for(int i=0; i<party.size(); i++){
        bool flag = false;
        for(int j=0; j<party[i].size(); j++){
            int par = find(party[i][j]);
            if(banned[par]){
                flag = true;
                break;
            }
        }

        if(!flag) result++;
    }

    cout << result;

    return 0;
}