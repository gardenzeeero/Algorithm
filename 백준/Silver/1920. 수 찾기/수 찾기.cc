#include <iostream>
#include <algorithm>
using namespace std;

vector<int> v;
int a;

bool checkFunction(int input){
    int left = 0, right = a-1, mid = (left + right)/ 2;
    while(left <= right){
        mid = (left + right)/ 2;
        if(input == v[mid]){
            return true;
        }else if(input < v[mid]){
            right = mid - 1;
        }else{
            left = mid + 1;
        }
    }
    return false;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    

    cin >> a;

    int input;
    for(int i=0; i<a; i++){
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end());

    int b;
    cin >> b;
    bool check;
    for(int i=0; i<b; i++){
        cin >> input;
        check = checkFunction(input);
        if(check){
            cout << 1 << "\n";
        }else{
            cout << 0 << "\n";
        }
    }
}