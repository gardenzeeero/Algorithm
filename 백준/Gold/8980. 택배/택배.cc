#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int townTruck[2001];
vector< pair<pair<int, int>, int> >v;
int sum = 0;

void check(pair<int, int> town, int box){
    int first = town.first, second = town.second;

    for(int i = first; i < second; i++){
        if(townTruck[i] < box){
            box = townTruck[i];
        }
    }

    for(int i = first; i < second; i++){
        townTruck[i] -= box;
    }

    sum += box;
}

bool compare(pair<pair<int, int>, int > a, pair<pair<int, int>, int > b){
    if(a.first.second < b.first.second){
        return true;
    }else if(a.first.second == b.first.second && a.first.first < b.first.first){
        return true;
    }else{
        return false;
    }
}


int main(){
    int town, truck;
    cin >> town >> truck;
    for(int i=1; i<town; i++){
        townTruck[i] = truck;
    }

    int infoCount;
    cin >> infoCount;

    int a, b, box;
    for(int i=0; i<infoCount; i++){
        cin >> a >> b >> box;
        pair<int, int> p1 = make_pair(a, b);
        pair<pair<int, int>, int> p2 = make_pair(p1, box);
        v.push_back(p2);
    }

    sort(v.begin(), v.end(), compare);
    for(int i=0; i<v.size(); i++){
        check(v[i].first, v[i].second);
    }


    cout << sum;


    return 0;
}