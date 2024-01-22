#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int a;
    cin >> a;
    vector<int> v;
    for(int i=0; i<a; i++){
        int input;
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end());
    for(int i=0; i<v.size(); i++){
        cout << v[i] << "\n";
    }
}