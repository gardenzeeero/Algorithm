#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int count = 0;
    int input;
    for(int i=0; i<5; i++){
        cin >> input;
        count += input * input;
    }
    cout << count %10;




    return 0;
}