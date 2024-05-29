#include <bits/stdc++.h>
using namespace std;

int dl, pl; //뭔가 해야하는 마지막집
vector<int> d, p;

void findLast(){
    bool cd = false, cp = false;
    for(int i=dl; i >= 0; i--){
        if(d[i] != 0){
            dl = i;
            cd = true;
            break;
        }
    
    }
    for(int i=pl; i >=0; i--){
        if(p[i] != 0){
            pl = i;
            cp = true;
            break;
        }
    }
    if(!cd) dl = -1;
    if(!cp) pl = -1;
    
}

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    
    //뒤에서 부터 배달해주고 뒤에서 부터 빼온다.
    d = deliveries, p = pickups;
    dl = d.size()-1; pl = p.size()-1;
    long long answer = 0;
    
    findLast();
    while(dl != -1 || pl != -1){
        int last = max(dl, pl);
        //가는 동안 뒤에 집부터 배달하기
        int temp = cap;
        for(int i=dl; i >= 0; i--){
            if(d[i] > 0){
                //cap이 남았을 때
                if(temp >= d[i]){
                    temp -= d[i];
                    d[i] = 0;
                }
                //cap이 부족할때
                else{
                    d[i] -= temp;
                    temp = 0;
                    break;
                }
            }
        }
        
        temp = cap;
        for(int i=pl; i >= 0; i--){
            if(p[i] > 0){
                if(temp >= p[i]){
                    temp -= p[i];
                    p[i] = 0;
                }
                else{
                    p[i] -= temp;
                    break;
                }
            }
        }
        
        answer += (last+1) * 2;
        findLast();
    }
    
    
    return answer;
}