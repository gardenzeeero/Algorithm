#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    string input;
    string str;
    for(int i=0; i<8; i++){
        cin >> input;
        str += input;
    }
    if(str =="12345678"){
        cout << "ascending";
    }else if(str == "87654321"){
        cout << "descending";
    }else{
        cout << "mixed";
    }
}