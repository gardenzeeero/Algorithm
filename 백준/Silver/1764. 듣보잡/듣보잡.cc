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

    int n, m;
    cin >> n >> m;

    vector<string> v;
    string input;
    for(int i=0; i<n; i++){
        cin >> input;
        v.push_back(input);
    }

    sort(v.begin(), v.end());

    vector<string> v2;
    int left, right, mid;
    for(int i=0; i<m; i++){
        cin >> input;
        left = 0; right = v.size()-1; mid = (left+right)/2;
        while(left <= right){
            if(v[mid] == input){
                v2.push_back(input);
                break;
            }else if(v[mid] < input){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            mid = (left+right)/2;
        }
    }
    
    sort(v2.begin(), v2.end());

    cout << v2.size() << "\n";
    for(int i=0; i<v2.size(); i++){
        cout << v2[i] << "\n";
    }


    return 0;

}