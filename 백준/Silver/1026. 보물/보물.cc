#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int numCase;
    cin >> numCase;

    int input;
    vector<int> a, b;
    for(int i=0 ;i<numCase; i++){
        cin >> input;
        a.push_back(input);
    }
    sort(a.begin(), a.end());

    for(int i=0 ;i<numCase; i++){
        cin >> input;
        b.push_back(input);
    }
    sort(b.begin(), b.end(), greater<int>());

    int sum = 0;
    for(int i=0; i<a.size(); i++){
        sum += a[i]*b[i];
    }

    cout << sum;
    return 0;
}