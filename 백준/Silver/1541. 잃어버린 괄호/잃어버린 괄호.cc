#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

int main(){
    string input;
    cin >> input;
    bool find = false;
    int findIdx, count = 1;
    for(int i=0; i<input.size(); i++){
        if(input[i] == '+' || input[i] == '-'){
            if(!find && input[i] == '-'){
                findIdx = count;
                find = true;
            }
            input[i] = ' ';
            count++;
        }
    }

    stringstream ss;
    ss.str(input);

    vector<int> v;
    string temp;
    while(getline(ss, temp, ' ')){
        v.push_back(stoi(temp));
    }

    int sum = 0;
    for(int i=0; i<v.size(); i++){
        if(findIdx <= i && find){
            sum -= v[i];
        }else{
            sum += v[i];
        }
    }

    cout << sum;






    return 0;
}
