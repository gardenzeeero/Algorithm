#include <iostream>
#include <vector>
using namespace std;


int townTruck[2001];
vector< pair<pair<int, int>, int> >v[2001];
int sum = 0;

void check(pair<int, int> town, int box){
    int first = town.first, second = town.second;

    int min = 100000;
    for(int i = first; i < second; i++){
        if(townTruck[i] < min){
            min = townTruck[i];
        }
    }
    if(min < box){
        box = min;
    }

    for(int i = first; i < second; i++){
        townTruck[i] -= box;
    }

    sum += box;
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
        v[b-a].push_back(p2);
    }

    for(int i=1; i<town; i++){
        for(int j=0; j<v[i].size(); j++){
            check(v[i][j].first, v[i][j].second);
        }
    }


    cout << sum;


    return 0;
}