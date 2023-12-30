#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int a, b;
    while (!(cin >> a >> b).eof()) {	// 혹은 eof() 대신 fail()을 사용해도 된다.
        cout << a + b << "\n";
    }

    return 0;
}