#include <bits/stdc++.h>
#include <tuple>
using namespace std;

bool compare(pair<int, string> a, pair<int, string> b){
    if(a.first < b.first){
        return true;
    }else{
        return false;
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int a;
    cin >> a;
    vector<pair<int, string> > v;
    for(int i=0; i<a; i++){
        int age;
        string name;
        cin >> age >> name;
        v.push_back(pair<int, string>(age, name));
    }
    stable_sort(v.begin(), v.end(), compare);

    for(int i=0; i<a; i++){
        cout << v[i].first << " " << v[i].second << "\n";
    }

}