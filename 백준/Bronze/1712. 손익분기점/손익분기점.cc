#include <iostream>
using namespace std;

int main(){
    int base, each, income;
    cin >> base >> each >> income;

    if(each>=income){
        cout << -1;
        return 0;
    }

    int count=0;
    cout << base/(income-each) + 1;



}