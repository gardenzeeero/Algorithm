#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int size;
    cin >> size;

    long long input;
    int countArr[63] = {0,};
    for(int i=1; i<=size; i++){
        int countNum = 0;
        cin >> input;
        if(input != 0){
            while(input != 1){
                input /= 2;
                countNum++;
            }
            countArr[countNum]++;
        }
    }

    for (int i = 0; i <= 62; i++) {
        if (countArr[i] >= 2) {
            int plus = countArr[i]/2;
            countArr[i + 1] += plus;
        }

    }
    int max = 0;
    for (int i = 0; i <=62; i++) {
        if (countArr[i] > 0) {
            max = i;
        }
    }

    long long output = 1;
    for(int i=0; i<max; i++){
        output *= 2;
    }
    cout << output;

    return 0;
}