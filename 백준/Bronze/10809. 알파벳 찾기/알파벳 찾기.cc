#include <iostream>
#include <vector>
using namespace std;

int main() {
    string input;
    char a = 'a';

    cin >> input;
    for(int i='a'; i<='z'; i++){
        bool check = false;
        for(int j=0; j<input.length(); j++){
            if(input[j] == i){
                check = true;
                cout << j << " ";
                break;
            }
        }
        if(!check) cout << "-1 ";
    }


    return 0;
}