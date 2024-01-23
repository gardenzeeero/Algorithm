#include <bits/stdc++.h>
using namespace std;


vector<int> v;
bool check(int b){
    for(int i=0; i<v.size(); i++){
        if(v[i] == b) return true;
    }
    return false;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int m;
    cin >> m;



    for(int i=0; i<m; i++){
        string a;
        int b;
        cin >> a;
        if(a == "add"){
            cin >> b;
            if(check(b)) continue;
            else v.push_back(b);
        }else if(a == "check"){
            cin >> b;
            if(check(b)) cout << "1\n";
            else cout << "0\n";
        }else if(a == "remove"){
            cin >> b;
            if(check(b)){
                for(int j=0; j<v.size(); j++){
                    if(v[j] == b){
                        v.erase(v.begin()+j);
                    }
                }
            }
        }else if(a == "toggle"){
            cin >> b;
            if(check(b)){
                for(int j=0; j<v.size(); j++){
                    if(v[j] == b){
                        v.erase(v.begin()+j);
                    }
                }
            }else{
                v.push_back(b);
            }
        }else if(a == "all"){
            v.clear();
            for(int j=1; j<=20; j++){
                v.push_back(j);
            }
        }else{
            v.clear();
        }
    }
}