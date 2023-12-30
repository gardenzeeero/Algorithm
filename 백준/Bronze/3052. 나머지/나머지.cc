#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int rest[42] = {0, };
    int input;
    for(int i=0; i<10; i++){
        cin >> input;
        rest[input%42]++;
    }

    int sum = 0;
    for(int i=0; i<42; i++){
        if(rest[i] != 0) sum++;
    }

    cout << sum;
}