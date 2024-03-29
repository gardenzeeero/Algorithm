#include <bits/stdc++.h>
using namespace std;

string arr[51][51];
int dx[4] = {1, 0, 0, -1};
int dy[4] = {0, -1, 1, 0};
int fn, fm, fk, fr, fc;
string minSt = "";

bool check(string temp){
    for(int i=0; i<temp.size(); i++){
        if(temp[i] > minSt[i]) return true;
        else if(temp[i] < minSt[i]) return false;
    }
    return true;
}

bool canGo(int cx, int cy, int count){
    int dist = abs(fr-cx) + abs(fc-cy);
    if(dist > fk-count) return false;
    if(dist%2 == 0 && (fk-count)%2 == 1) return false; 
    return true;
}

void dfs(int cx, int cy, int count, string st){
    if(count == fk){
        if(cx == fr && cy == fc) {
            minSt = st;
        }
        return;
    }
    
    for(int i=0; i<4; i++){
        int nx = cx + dx[i], ny = cy + dy[i];
        if(nx < 1 || nx > fn || ny < 1 || ny > fm) continue;
        string temp;
        if(i == 0) temp = st + "d";
        else if(i == 1) temp = st + "l";
        else if(i == 2) temp = st + "r";
        else if(i == 3) temp = st + "u";
        if(minSt != "" && check(temp)) continue;
        if(!canGo(nx, ny, count+1)) continue;

        dfs(nx, ny, count+1, temp);
    }
}

string solution(int n, int m, int x, int y, int r, int c, int k) {
    fn = n; fm = m; fk = k; fr = r; fc = c;
    
    dfs(x, y, 0, "");
    
    string answer;
    if(minSt == ""){
        answer = "impossible";
    }else{
        answer = minSt;
    }
    
    
    
    
    return answer;
    
}