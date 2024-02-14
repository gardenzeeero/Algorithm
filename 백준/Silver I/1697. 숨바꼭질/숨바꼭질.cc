#include <iostream>
#include <queue>
using namespace std;

int arr[100001];


int main(){
    int su, dong;
    cin >> su >> dong;

    for(int i=0; i<100001; i++){
        arr[i] = 1000000;
    }

    queue<int> q;
    q.push(dong);
    arr[dong] = 0;
    while(!q.empty()){
        int cur = q.front(); q.pop();

        int next = cur + 1;
        if(arr[next] > arr[cur] + 1) {
            arr[next] = arr[cur] + 1;
//            cout << next << ":" << arr[next] << "\n";
            q.push(next);
        }
        next = cur - 1;
        if(arr[next] > arr[cur] + 1) {
            arr[next] = arr[cur] + 1;
//            cout << next << ":" << arr[next] << "\n";
            q.push(next);
        }

        if(cur % 2 == 0 && cur != 0){
            next = cur/2;
            if(arr[next] > arr[cur] + 1) {
                arr[next] = arr[cur] + 1;
//                cout << next << ":" << arr[next] << "\n";
                q.push(next);
            }
        }
    }

    cout << arr[su];

    return 0;
}