#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

bool desc(int a, int b){
    return a > b;
}

int main(){
    int testCase;
    cin >> testCase;
    int test[40];

    int input=1;
    int index=0;
    long long sum=0;
    vector<string> output;
    for(int i=0; i<testCase; i++){
        index=0;
        sum=0;
        while(true){
            cin >> input;
            if(input == 0){
                break;
            }
            test[index++] = input;
        }
        sort(test, test+index, desc);
        for(int i=0; i<index; i++){
            sum += 2*pow(test[i], i+1);
        }

        if(sum >= 5000000){
            output.push_back("Too expensive");
        }else{
            output.push_back(to_string(sum));
        }
    }
    vector<string>::iterator it;
    for(it=output.begin(); it!=output.end(); it++){
        cout << *it << '\n';
    }
}