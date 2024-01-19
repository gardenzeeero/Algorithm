#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int personCase;
    cin >> personCase;

    int input;
    vector<int> v;
    while(personCase--){
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end());
    int sum = 0, temp = 0;
    for(int i=0; i<v.size(); i++){
        temp += v[i];
        sum += temp;
    }

    cout << sum;
    return 0;
}