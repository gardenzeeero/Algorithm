#include <iostream>
#include <queue>
#include <string>
using namespace std;

int doIt(queue<int> &intQueue, queue<char> &charQueue){
    int count = 0, sum = 0;
    int back;
    while(!intQueue.empty()){
        if(count == 0){
            sum = intQueue.front();
            intQueue.pop();
            count++;
        }
        if(charQueue.empty()){
            break;
        }
        switch (charQueue.front()) {
            case('S'):{
                back = intQueue.front();
                intQueue.pop();
                sum -= back;
                break;
            }
            case('M'): {
                back = intQueue.front();
                intQueue.pop();
                sum *= back;
                break;
            }
            case('U'):{
                back = intQueue.front();
                intQueue.pop();
                sum /= back;
                break;
            }
            case('P'):{
                back = intQueue.front();
                intQueue.pop();
                sum += back;
                break;
            }
        }
        charQueue.pop();
    }
    return sum;
}

int main(){
    int sign;
    cin >> sign;

    string input;
    cin >> input;

    queue<int> intQueue;
    queue<char> charQueue;
    int sum = 0, startIdx = 0, countOutput=0;

    for(int i=0; i<input.size(); i++){
        if('A' < input[i] && input[i] < 'Z'){
            if(input[i-1] != 'C'){
                string intPush = input.substr(startIdx, i-startIdx);
                intQueue.push(stoi(intPush));
            }
            if(input[i] == 'C'){
                sum = doIt(intQueue, charQueue);
                intQueue.push(sum);
                cout << sum << ' ';
                countOutput++;
            }else{
                charQueue.push(input[i]);
            }
            startIdx = i+1;
        }
    }
    if(countOutput == 0){
        cout << "NO OUTPUT";
    }


    return 0;
}