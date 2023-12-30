#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int input;
    int maxInt=-1;
    int maxIdx;

    for(int i=1; i<=9; i++){
        cin >> input;
        if(input > maxInt){
            maxInt = input;
            maxIdx = i;
        }
    }
    cout << maxInt << "\n" << maxIdx;




    return 0;
}