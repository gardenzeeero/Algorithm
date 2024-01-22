#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    string input;
    int a;
    cin >> a;
    stack<char> s;
    char c;
    for(int i=0; i<a; i++){
        cin >> input;
        int count = 0;
        int check = false;
        for(int j=0; j<input.size(); j++){
            if(input[j] == '(') count++;
            else{
                count--;
                if(count < 0){
                    check = true;
                    break;
                }
            }
        }
        if(!check && count == 0) cout << "YES\n";
        else cout << "NO\n";
    }

}