#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int ropeCase;
    cin >> ropeCase;

    int input;
    vector<int> v;
    while(ropeCase--){
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end());
    int count = 1, total = 0;
    for(int i=v.size()-1; i>=0; i--){
        if(v[i]*count > total) total = v[i]*count;
        count++;
    }

    cout << total;

    return 0;
}