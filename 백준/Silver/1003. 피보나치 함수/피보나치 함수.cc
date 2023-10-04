#include <iostream>
using namespace std;


int main() {
    int count, x;
    int a, b, c;
    cin >> count;
    
    for(int i=0; i<count; i++){
        a = 1; b = 0; c = 0;
        cin >> x;
        for(int i=0; i<x; i++){
            c = a;
            a = b;
            b = c + b;
        }
        cout << a << " ";
        cout << b << endl;
        
    }
    
    return 0;
}


