#include <iostream>
using namespace std;

int main(){
    int block;
    cin >> block;

    int jump[200001];
    for(int i=1; i<=block; i++){
        cin >> jump[i];
    }

    int output[200001];
    for(int i=block; i != 0; i--){
        if(i+jump[i]+1 > block){
            output[i] = 1;
        }else{
            output[i] = output[i+jump[i]+1]+1;
        }
    }

    for(int i=1; i<=block; i++){
        cout << output[i] << " ";
    }




}