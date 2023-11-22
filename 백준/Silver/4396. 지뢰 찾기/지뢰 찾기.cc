//
// Created by 정원영 on 11/22/23.
//

#include <iostream>
using namespace std;

int find(int i, int j);

int row[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int col[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
char arr[10][10];
char open[10][10];
int output[10][10];
int arrSize;
bool boom = false;

int main(){
    cin >> arrSize;
    for(int i=0; i<arrSize; i++){
        for(int j=0; j<arrSize; j++){
            cin >> arr[i][j];
        }
    }

    for(int i=0; i<arrSize; i++){
        for(int j=0; j<arrSize; j++){
            cin >> open[i][j];
        }
    }

    for(int i=0; i<arrSize; i++){
        for(int j=0; j<arrSize; j++){
            if(arr[i][j] == '*'){
                output[i][j] = '*';
                if(open[i][j] == 'x'){
                    boom = true;
                }
            }else{
                output[i][j] = find(i, j);
            }
        }
    }

    for(int i=0; i<arrSize; i++){
        for(int j=0; j<arrSize; j++){
            if(boom && arr[i][j] == '*'){
                cout << '*';
            }else if(open[i][j] == 'x'){
                cout << output[i][j];
            }else{
                cout << '.';
            }
        }
        cout << '\n';
    }


    return 0;
}

int find(int i, int j){
    int count = 0;
    for(int k=0; k<8; k++){
        int arrRow = i + row[k];
        int arrCol = j + col[k];
        if(arrRow >= 0 && arrCol >= 0 && arrRow < arrSize && arrCol < arrSize){
            if(arr[arrRow][arrCol] == '*'){
                count++;
            }
        }
    }
    return count;
}