#include <iostream>
#include <vector>
using namespace std;

int sortRight(vector<int> numVec, vector<int> zeroVec){
    int count = numVec.size()-1;
    int sum = 0;
    while(!zeroVec.empty()){
        sum += count - zeroVec.back();
        count--;
        zeroVec.pop_back();
    }

    return sum;
}

int sortLeft(vector<int> numVec, vector<int> zeroVec){
    int count = 0;
    int sum = 0;
    while(!zeroVec.empty()){
        sum += zeroVec.front() - count;
        count++;
        zeroVec.erase(zeroVec.begin());
    }

    return sum;
}

int main(){
    int arrSize;
    cin >> arrSize;

    int inputNum;
    vector<int> numVec, zeroVec;
    for(int i=0; i<arrSize; i++){
        cin >> inputNum;
        numVec.push_back(inputNum%2);
        if(inputNum%2 == 0){
            zeroVec.push_back(i);
        }
    }

    int output1, output2;
    output1 = sortRight(numVec, zeroVec);
    output2 = sortLeft(numVec, zeroVec);
    if(output1 < output2){
        cout << output1;
    }else{
        cout << output2;
    }


}