//
// Created by 정원영 on 11/27/23.
//

#include <iostream>
#include <string>
using namespace std;

int input;
int maxInt = 0, minInt = 100000000;

int findLoop(int a);
int horse(string str);

int main(){
    cin >> input;

    findLoop(input);

    cout << minInt << " " << maxInt;

    return 0;
}

int findLoop(int a){
    int count;
    if(a <= 99 && a >= 10){
        count = horse(to_string(a)) + findLoop(a/10 + a%10);
    }else if(a < 10){
        count = a%2;
    }else{
        string temp = to_string(a);
        for(int i=1; i<=temp.length()-2; i++){
            for(int j=1; j<=temp.length()-i-1; j++){
                count = horse(to_string(a));
                int plus = stoi(temp.substr(0,i)) + stoi(temp.substr(i, j)) + stoi(temp.substr(i+j, temp.length()-i-j));
                count += findLoop(plus);
                if(a == input){
                    if(count > maxInt) maxInt = count;
                    if(count < minInt) minInt = count;
                }
            }
        }
    }



    return count;
}

int horse(string str){
    int count = 0;
    for(int i=0; i<str.length(); i++){
        if( (int)str[i]%2 == 1) count++;
    }
    return count;
}
