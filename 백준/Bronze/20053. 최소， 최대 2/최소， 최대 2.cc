//
// Created by 정원영 on 11/18/23.
//

#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int repeat, size, input, min, max;
    cin >> repeat;
    for(int i=0; i<repeat; i++){
        min = 1000000;
        max = -1000000;
        cin >> size;
        for(int j=0; j<size; j++) {
            cin >> input;
            if(min > input){
                min = input;
            }
            if(max < input){
                max = input;
            }
        }
        cout << min << " " << max << "\n";
    }


    return 0;
}