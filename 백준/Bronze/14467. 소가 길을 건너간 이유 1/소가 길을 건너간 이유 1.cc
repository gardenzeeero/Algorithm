//
// Created by 정원영 on 11/18/23.
//

#include <iostream>

using namespace std;

int main(){
    int cycle, sheep, pos;
    int count = 0;
    int sheepArr[11] = {0, };
    cin >> cycle;
    for(int i=0; i<cycle; i++){
        cin >> sheep >> pos;
        pos++;
        if(sheepArr[sheep] == 0 ){
            sheepArr[sheep] = pos;
        }else if(sheepArr[sheep] != pos){
            sheepArr[sheep] = pos;
            count++;
        }

    }

    cout << count;

    return 0;
}