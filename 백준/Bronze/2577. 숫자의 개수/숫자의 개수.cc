#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int a[10] = {0, };

    int input;
    long sum = 1;
    for(int i=0; i<3; i++){
        cin >> input;
        sum *= input;
    }


    string s = to_string(sum);
    for(int i=0; i<= s.length(); i++){
        a[s[i]-'0']++;
    }

    for(int i=0; i<10; i++){
        cout << a[i] << "\n";
    }







    return 0;
}