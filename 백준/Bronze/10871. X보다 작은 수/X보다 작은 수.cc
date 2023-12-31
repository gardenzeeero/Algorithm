#include <iostream>
#include <vector>
using namespace std;

int main() {
    int input, n, x;
    cin >> n >> x;

    vector<int> v;
    for(int i=0; i<n; i++){
        cin >> input;
        if(input < x){
            v.push_back(input);
        }
    }

    for(int i=0; i<v.size(); i++){
        cout << v[i] << " ";
    }
    

    return 0;
}