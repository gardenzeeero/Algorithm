#include <iostream>
#include <vector>
using namespace std;

bool find(vector<string> arr, string targetString, int row, int column, int k, int l, int index){
    if(index == targetString.size()){
        return true;
    }else if(row == arr.size() || column == arr[0].size() || row < 0 || column < 0){
        return false;
    }else if(arr[row][column] == targetString[index]){
        return find(arr, targetString, row+k, column+l, k, l, ++index);
    }
    return false;
}

int main() {
    string targetString;
    cin >> targetString;
    int row, column;
    cin >> row >> column;

    string input;
    vector<string> arr;
    for(int i=0; i<row; i++){
        cin >> input;
        arr.push_back(input);
    }

    bool result = false;
    for(int k=-1; k<=1; k++){
        for(int l=-1; l<=1; l++){
            if(k == 0 && l == 0){
                continue;
            }
            for(int i=0; i<arr.size(); i++){
                for(int j=0; j<arr[0].size(); j++){
                    result = find(arr, targetString, i, j, k, l, 0);
                    if(result){
                        cout << 1;
                        return 0;
                    }
                }
            }

        }
    }

    cout << 0;


}