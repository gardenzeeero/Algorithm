//
// Created by 정원영 on 11/18/23.
//

#include <iostream>

using namespace std;


int check(int arr[][5]){
    int count = 0;
    int count1, count2;
    for(int i=0; i<5; i++){
        count1 = 0 , count2 = 0;
        for(int j=0; j<5; j++){
            if(arr[i][j] == 0){
                count1++;
            }
            if(arr[j][i] == 0){
                count2++;
            }
        }
        if(count1 == 5){
            count += 1;
        }
        if(count2 == 5){
            count += 1;
        }
    }

    count1 = 0, count2 = 0;
    for(int i=0; i<5; i++){
        if(arr[i][i] == 0){
            count1++;
        }
        if(arr[i][4-i] == 0){
            count2++;
        }
    }
    if(count1 == 5){
        count += 1;
    }
    if(count2 == 5){
        count += 1;
    }

    if(count >= 3){
        return 1;
    }else{
        return 0;
    }
}
int main(){
    int arr[5][5];
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            cin >> arr[i][j];
        }
    }

    int input;
    for(int i=0; i<25; i++){
        cin>> input;
        for(int j=0; j<5; j++){
            for(int k=0; k<5; k++){
                if(arr[j][k] == input){
                    arr[j][k] = 0;
                    j = 5;
                    k = 5;
                }
            }
        }
        if(check(arr) == 1){
            cout << i+1;
            break;
        }
    }

    return 0;
}