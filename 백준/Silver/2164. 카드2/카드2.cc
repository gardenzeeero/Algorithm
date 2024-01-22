#include <iostream>
#include <deque>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int input;
    cin >> input;

    deque<int> dq;
    for(int i=1; i<=input; i++){
        dq.push_back(i);
    }

    while(true){
        if(dq.size() == 1){
            cout << dq.front();
            break;
        }

        dq.pop_front();
        if(dq.size() == 1){
            cout << dq.front();
            break;
        }
        int temp = dq.front();
        dq.push_back(temp);
        dq.pop_front();
    }

}