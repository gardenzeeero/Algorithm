#include <string>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> answer;

void hanoi(int n, int start, int with, int end){
    vector<int> temp;
    
    if(n != 1){
        hanoi(n-1, start, end, with);
        temp.push_back(start);
        temp.push_back(end);
        answer.push_back(temp);
        hanoi(n-1, with, start, end);
    }else{
        temp.push_back(start);
        temp.push_back(end);
        answer.push_back(temp);
    }
}

vector<vector<int>> solution(int n) {
    
    hanoi(n, 1, 2, 3);
   
    return answer;
}