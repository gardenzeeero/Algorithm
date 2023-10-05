#include <iostream>
using namespace std;

int main(){
    int height, width;
    cin >> height;
    cin >> width;

    int arr[500];
    for(int i=0; i<width; i++){
        cin >> arr[i];
    }

    int sum = 0;
    int index = -1;
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if((arr[j]-i) > 0){
                if(index != -1){
                    sum += j-index-1;
                }
                index = j;
            }
        }
        index = -1;
    }

    cout << sum;

    return 0;
}