#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int a, int b){
    if(a>0) return a>b;
    else return a < b;
}
vector<int> m,p;
int main(){
    int s;
    cin >> s;

    int input;
    for(int i=0; i<s; i++){
        cin >> input;
        if(input > 0){
            p.push_back(input);
        }else{
            m.push_back(input);
        }
    }

    if(!p.empty()) sort(p.begin(), p.end(), compare);
    if(!m.empty()) sort(m.begin(), m.end(), compare);



    int sum = 0;
    for(int i=0; i<p.size(); i++){
        if(i%2 == 0) continue;
        if (p[i] * p[i-1] > p[i] + p[i-1]) sum += p[i] * p[i-1];
        else sum += p[i] + p[i-1];
    }
    for(int i=0; i<m.size(); i++){
        if(i%2 == 0) continue;
        sum += m[i] * m[i-1];
    }

    if(p.size()%2 != 0){
        sum += p[p.size()-1];
    }
    if(m.size()%2 != 0){
        sum += m[m.size()-1];
    }

    cout << sum;

    return 0;
}