#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int memberCount;
    cin >> memberCount;

    int grade[100000];
    for(int i=0; i<memberCount; i++){
        cin >> grade[i];
    }

    vector<int> order;
    sort(grade, grade+memberCount);
    for(int i=0; i<memberCount; i++){
        if(i%2 != 0){
            order.push_back(grade[i/2]);
        }else{
            order.push_back(grade[memberCount-1-(i/2)]);
        }
    }

    int output = order[0];
    for(int i=memberCount-1; i>0; i--){
        int temp = order[i] - order[i-1];
        if(temp < 0){
            continue;
        }
        output += temp;
    }

    cout << output;

    return 0;
}