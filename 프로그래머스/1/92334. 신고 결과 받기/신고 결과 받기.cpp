#include <bits/stdc++.h>
using namespace std;

vector<int> answer;
vector<string> reportedFrom[1000];
bool contains(int j, string from){
    for(int i=0; i<reportedFrom[j].size(); i++){
        if(reportedFrom[j][i] == from) return true;
    }
    return false;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    
    
    for(int i=0; i<id_list.size(); i++){answer.push_back(0);}
    int person = id_list.size();
    
    for(int i=0; i<report.size(); i++){
        int idx = report[i].find(" ");
        string from = report[i].substr(0, idx);
        string to = report[i].substr(idx+1);
        for(int j=0; j<person; j++){
            if(id_list[j] == to) {
                if(contains(j, from)) break;
                reportedFrom[j].push_back(from);
                break;
            }
        }
    }
    
    
    
    for(int i=0; i<person; i++){
        if(reportedFrom[i].size() >= k){
            for(int j=0; j<reportedFrom[i].size(); j++){
                for(int k=0; k<person; k++){
                    if(id_list[k] == reportedFrom[i][j]) {
                        answer[k]++;
                        break;
                    }
                }
            }
        }
    }
    
    
    return answer;
}

