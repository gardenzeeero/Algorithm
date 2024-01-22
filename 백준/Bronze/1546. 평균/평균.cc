#include <iostream>
#include <algorithm>
using namespace std;



int main(){
    int a;
    cin >> a;


    double input;
    double sum = 0;
    vector<double> v;
    for(int i=0; i<a; i++){
        cin >> input;
        v.push_back(input);
    }

    double max = -1;
    for(int i=0; i<v.size(); i++){
        if(max < v[i]) max = v[i];
    }
    for(int i=0; i<v.size(); i++){
        v[i] = v[i]/max * 100;
        sum += v[i];
    }

    cout << sum/a;
}