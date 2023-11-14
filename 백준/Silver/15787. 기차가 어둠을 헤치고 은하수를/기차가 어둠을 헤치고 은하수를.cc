//
// Created by 정원영 on 11/14/23.
//

#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){
    int train, oper;
    cin >> train >> oper;
    vector<string> trainVec;
    for(int i=0; i<train; i++){
        trainVec.push_back("00000000000000000000");
    }

    int operand1, operand2;
    for(int i=0; i<oper; i++){
        cin >> operand1 >> train;
        train--;
        switch (operand1) {
            case 1:
                cin >> operand2;
                operand2--;
                trainVec[train][operand2] = '1';
                break;
            case 2:
                cin >> operand2;
                operand2--;
                trainVec[train][operand2] = '0';
                break;
            case 3:
                trainVec[train] = "0" + trainVec[train].substr(0, 19);
                break;
            case 4:
                trainVec[train] = trainVec[train].substr(1, 19) + "0";
                break;
        }
    }

    int count = 0;
    for(int i=0; i<trainVec.size(); i++){
        bool check = true;
        for(int j=0; j<i; j++){
            if(trainVec[i] == trainVec[j]){
                check = false;
                break;
            }
        }
        if(check){
            count++;
        }
    }

    cout << count;

    return 0;
}