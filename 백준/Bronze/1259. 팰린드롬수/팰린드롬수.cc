#include <iostream>
#include <algorithm>
using namespace std;



int main(){
    string input;
    string temp;
    while(true){
        cin >> input;
        if(input == "0") break;

        temp = "";
        for(int i=input.size()-1; i>=0; i--){
            temp += input[i];
        }

        if(temp == input) cout << "yes" << "\n";
        else cout << "no" << "\n";
    }
}