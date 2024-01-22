#include <iostream>
#include <algorithm>
using namespace std;

string input;
vector<string> v;

bool compare(string a, string b){
    if(a.size() < b.size()){
        return true;
    }else if(a.size() == b.size()){
        if(a < b){
            return true;
        }else{
            return false;
        }
    }else{
        return false;
    }
}

int main(){
    int a;
    cin >> a;


    for(int i=0; i<a; i++){
        bool check = false;
        cin >> input;

        for(int j=0; j<v.size(); j++){
            if(v[j] == input) check = true;
        }

        if(!check){
            v.push_back(input);
        }

    }

    sort(v.begin(), v.end(), compare);

    for(int i=0; i<v.size(); i++){
        cout << v[i] << "\n";
    }


    return 0;
}