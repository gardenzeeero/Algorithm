#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int coinCase, total, input;
    vector<int> v;
    cin >> coinCase >> total;
    while(coinCase--){
        cin >> input;
        v.push_back(input);
    }

    int sum = 0;
    for(int i=v.size()-1; i>=0; i--){
        if(total/v[i] > 0){
            sum += total/v[i];
            total -= total/v[i] * v[i];
        }
    }


    cout << sum;

    return 0;
}