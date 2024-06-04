#include <bits/stdc++.h>
using namespace std;

bool check(string p){
    vector<char> stack;
    int lc = 0, rc = 0;
    for(int i=0; i<p.length(); i++){
        if(p[i] == '('){
            stack.push_back(p[i]);
        }else{
            if(!stack.empty() && stack.back() == '(') stack.pop_back();
            else return false;
        }
    }
    return true;
}

int find(string p){
    int lc = 0, rc = 0;
    for(int i=0; i<p.length(); i++){
        if(p[i] == '(') lc++;
        else rc++;
        
        if(lc == rc) return i;
    }
    return p.length()-1;
}

string reverse(string p){
    string result = "";
    for(int i=1; i<p.length()-1; i++){
        if(p[i] == '(') result += ')';
        else result += '(';
    }
    return result;
}


string recursive(string p){
    if(p == "") return p;
    
    string u = p.substr(0, find(p)+1);
    string v = p.length() == u.length() ? "" : p.substr(find(p)+1);
    
    if(check(u)) return u + recursive(v);         
    else return "(" + recursive(v) + ")" + reverse(u);
}


string solution(string p) {
    string answer;
    if(check(p)){
        answer = p;
    }else{
        answer = recursive(p);
    }
    
    return answer;
}