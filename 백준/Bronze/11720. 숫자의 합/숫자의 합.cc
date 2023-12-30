#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    string input;
    int loop;
    int sum = 0;
    cin >> loop >> input;
    for(int i=0; i<input.length(); i++){
        sum += input[i]-48;
    }

    cout << sum;



    return 0;
}