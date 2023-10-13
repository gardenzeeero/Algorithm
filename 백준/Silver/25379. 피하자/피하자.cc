#include <iostream>
#include <vector>
using namespace std;

int sort(vector<int> numVec, vector<int> zeroVec, int direction){
    int count = 0, zeroIdx;
    int cycle = zeroVec.size();
    for(int i=0; i<cycle; i++){
        if(direction == 1){
            zeroIdx = zeroVec.back();
            zeroVec.pop_back();
            if(zeroIdx == numVec.size()-1){
                continue;
            }
        }else{
            zeroIdx = zeroVec.front();
            zeroVec.erase(zeroVec.begin());
            if(zeroIdx == 0){
                continue;
            }
        }

        while(true){
            if(numVec[zeroIdx+direction] == 0 ){
                break;
            }
            int temp = numVec[zeroIdx];
            numVec[zeroIdx] = numVec[zeroIdx+direction];
            numVec[zeroIdx+direction] = temp;
            zeroIdx += direction;
            count++;
        }

    }
    return count;
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
    output1 = sort(numVec, zeroVec, 1);
    output2 = sort(numVec, zeroVec, -1);
    if(output1 < output2){
        cout << output1;
    }else{
        cout << output2;
    }


}