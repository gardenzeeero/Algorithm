#include <bits/stdc++.h>
using namespace std;

string find(long long input){
    string temp = "";
    while(input > 0){
        temp = to_string(input%2)+temp;
        input /= 2;
    }
    
    int tempSize = 1, tempInt = 1;
    while(tempSize < temp.length()){
        tempInt *= 2;
        tempSize += tempInt;
    }
    
    int a = temp.length();
    for(int i=0; i<tempSize - a; i++){
        temp = "0"+temp;
    }
    return temp;
}

int recursive(string temp, int start, int end){
    if(temp.size() == 1){
        if(temp[0] == '1') return 1;
        return -1;
    }
    
    int mid = (start+end)/2;
    if(end-start == 2){
        if(temp[mid] == '0'){
            if(temp[mid-1] == '0' && temp[mid+1] == '0') return 0;
            else return -1;
        }
        return 1;
    }else{
        int left = recursive(temp, start, mid-1), right = recursive(temp, mid+1, end);
        if(left == -1 || right == -1) return -1;
        else if(temp[mid] == '1') return 1;
        else if(left == 0 && right == 0) return 0;
        else return -1;
    }
}

vector<int> solution(vector<long long> numbers) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    vector<int> answer;
    string temp;
    for(int i=0; i<numbers.size(); i++){
        temp = find(numbers[i]);
        if(recursive(temp, 0, temp.size()-1) != -1){
            answer.push_back(1);
        }else{
            answer.push_back(0);
        }
    }
    
    return answer;
}