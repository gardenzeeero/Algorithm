#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    int start, end;
    vector<pair<int, int> > v;
    while(n--){
        cin >> start >> end;
        pair<int, int> p = make_pair(start, end);
        v.push_back(p);
    }

    sort(v.begin(), v.end());
    

    int tempStart = v[0].first, tempEnd = v[0].second;
    int sum = 0;
    for(int i=0; i<v.size(); i++){
        int vFirst = v[i].first, vSecond = v[i].second;
        if(tempEnd < vFirst){
            sum += tempEnd - tempStart;
            tempStart = vFirst;
            tempEnd = vSecond;
        }else if(tempEnd < vSecond){
            tempEnd = vSecond;
        }
    }

    sum += tempEnd - tempStart;
    cout << sum;
    return 0;
}