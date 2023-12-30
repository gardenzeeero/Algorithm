#include <iostream>
#include <string>
using namespace std;


int main(){
    string s;
    int count = 0;

    getline(cin, s);
    int stIdx=-1;
    for(int i=0; i<s.length(); i++){
        if(s[i] == ' ') {
            if(i - stIdx > 1){
                count++;
            }
            stIdx = i;
        }
    }
    if(stIdx != s.length()-1){
        count++;
    }
    cout << count;

    return 0;
}