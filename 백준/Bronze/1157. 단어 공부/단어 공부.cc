#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    string s;
    cin >> s;
    map<char, int> m;

    for(int i=0; i<s.length(); i++){
        char a = s[i];
        if(a >= 'a'){
            a = a - ('a'-'A');
        }
        if(m[a]){
            m[a]++;
        }else{
            m[a] = 1;
        }
    }

    int maxCount = -1;
    char maxChar;
    for(auto it : m){
        if(it.second > maxCount){
            maxCount = it.second;
            maxChar = it.first;
        }else if(it.second == maxCount){
            maxChar = '?';
        }
    }

    cout << maxChar;


    return 0;
}