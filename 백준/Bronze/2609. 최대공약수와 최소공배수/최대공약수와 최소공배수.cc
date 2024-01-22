#include <iostream>
#include <deque>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int a, b;
    cin >> a >> b;
    int max = a>b ? a : b;
    int min = a>b ? b : a;
    int result1, result2;
    for(int i=1; i<=min; i++){
        if(a%i == 0 && b%i == 0) result1 = i;
    }

    while(true){
        if(max%a == 0 && max%b == 0){
            result2 = max;
            break;
        }
        max++;
    }
    cout << result1 << "\n" << result2;

}