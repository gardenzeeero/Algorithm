#include <bits/stdc++.h>
using namespace std;


int arr[100001];

bool compare(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second){
        return a.first < b.first;
    }else{
        return a.second < b.second;
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int h;
    cin >> h;
    vector<pair<int, int> > v;
    for(int i=0; i<h; i++){
        int start, end;
        cin >> start >> end;
        v.push_back(pair<int, int>(start, end));
    }

    sort(v.begin(), v.end(), compare);


    int tempStart = v[0].first;
    int tempEnd = v[0].second;
    int count = 1;

    for(int i=1; i<v.size(); i++){
        if(v[i].first < tempEnd) continue;
        tempStart = v[i].first;
        tempEnd = v[i].second;
        count++;
    }

    cout << count;

    return 0;

}