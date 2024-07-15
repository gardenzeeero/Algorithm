#include <bits/stdc++.h>
using namespace std;

int n, m, input;
deque<int> dq;

int find(int input){
    for(int i=0; i<dq.size(); i++){
        if(dq[i] == input) return i;
    }
    return 0;
}

int main(){
    cin >> n >> m;

    
    for(int i=1; i<=n; i++){
        dq.push_back(i);
    }

    int result = 0;
    while(m--){
        cin >> input;
        int idx = find(input);
        
        if(idx <= dq.size()/2){
            for(int i=0; i<idx; i++){
                dq.push_back(dq.front());
                dq.pop_front();
                result++;
            }
            dq.pop_front();
        }else{
            for(int i=0; i<dq.size()-idx; i++){
                dq.push_front(dq.back());
                dq.pop_back();
                result++;
            }
            dq.pop_front();
        }
    }

    cout << result;

    return 0;
}