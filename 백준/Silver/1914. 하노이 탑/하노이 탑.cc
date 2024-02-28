#include <bits/stdc++.h>
using namespace std;


int n;
vector<pair<int, int> > v;

void hanoi(int n, int start, int with, int end){
    if(n != 1){
        hanoi(n-1, start, end, with);
        v.push_back({start, end});
        hanoi(n-1, with, start, end);
    }else{
        v.push_back({start, end});
    }
}

int main(){
    cin >> n;
    if(n <= 20){
        hanoi(n, 1, 2, 3);
        cout << v.size() << "\n";
        for(int i=0; i<v.size(); i++){
        cout << v[i].first << " " << v[i].second << "\n";
        }
    }else{
        string s = to_string(pow(2, n));
        int finddot = s.find('.');
        s = s.substr(0,finddot);
        s[s.length() -1] -= 1;
        cout << s << '\n';
    }

   
    
    return 0;
}