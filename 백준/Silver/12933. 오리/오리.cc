//
// Created by 정원영 on 11/14/23.
//
#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(){
    string input;
    string quack = "quack";
    cin >> input;

    queue<int> check;
    int output = 0;
    while(true){
        int count = 0, outputPlus = 0;
        for(int i=0; i<input.length(); i++){
            if(input[i] == quack[count]){
                check.push(i);
                count++;
                if(count == 5){
                    count = 0;
                }
            }
        }

        int checkSize = check.size()/5 * 5;
        for(int i=0; i<checkSize; i++){
            input[check.front()] = 'T';
            check.pop();
            outputPlus = 1;
        }

        while(check.size() != 0){
            check.pop();
        }
        output += outputPlus;

        if(count < 5 && outputPlus == 0){
            break;
        }
    }

    string comp = "";
    for(int i=0; i<input.size(); i++){
        comp += "T";
    }

    if(comp == input){
        cout << output;
    }else{
        cout << -1;
    }

    return 0;
}