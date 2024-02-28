#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<char> v;
int minPiro = 10000000;
int picks_size = 0;

void find(vector<string> &minerals){
    int temp = 0;
    int gockIdx = 0, mineralIdx = 0;
    while(true){
        if(gockIdx >= picks_size) break;
        if(mineralIdx >= minerals.size()) break;
        
        if(v[gockIdx] == 'd'){
            for(int i=mineralIdx; i<mineralIdx+5; i++){
                if(i >= minerals.size()) break;
                temp++;
            }
        }else if(v[gockIdx] == 'i'){
            for(int i=mineralIdx; i<mineralIdx+5; i++){
                if(i >= minerals.size()) break;
                if(minerals[i] == "diamond") temp += 5;
                else temp++;
            }
        }else{
            for(int i=mineralIdx; i<mineralIdx+5; i++){
                if(i >= minerals.size()) break;
                if(minerals[i] == "diamond") temp += 25;
                else if(minerals[i] == "iron") temp += 5;
                else temp++;
            }
        }
        mineralIdx += 5;
        gockIdx++;
    }
    minPiro = min(minPiro, temp);
}


int solution(vector<int> picks, vector<string> minerals) {
    for(int i=0; i<3; i++){
        for(int j=0; j<picks[i]; j++){
            picks_size++;
            if(i==0) v.push_back('d');
            else if(i==1) v.push_back('i');
            else v.push_back('s');
        }
    }
    
    
    sort(v.begin(), v.end());
    
    do{
        find(minerals);
    }while(next_permutation(v.begin(), v.end()));
    
    
    int answer = minPiro;
    return answer;
    
}