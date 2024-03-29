#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum1 = 0, sum2 = 0;
    for(int i=0; i<queue1.size(); i++){
        sum1 += queue1[i];
        sum2 += queue2[i];
    }
    
    long long idx1 = 0, idx2 = 0, count = 0;
    long long out = queue1.size() * 3;
    while(sum1 != sum2){
        if(count >= out){
            count = -1;
            break;
        }
        if(sum1 > sum2){
            sum1 -= queue1[idx1]; 
            sum2 += queue1[idx1]; queue2.push_back(queue1[idx1]);
            idx1++;
        }else{
            sum1 += queue2[idx2]; queue1.push_back(queue2[idx2]);
            sum2 -= queue2[idx2]; 
            idx2++;
        }
        count++;
    }
    
    int answer = count;
    return answer;
}