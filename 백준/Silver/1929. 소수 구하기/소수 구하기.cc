#include <iostream>
#include <vector>
using namespace std;

int main(){
    int start, end;
    cin >> start;
    cin >> end;

    int arr[100001];
    int index =0;
    arr[index++] = 1;
    int count;
    for(int i=2; i<=end; i++) {
        count = 0;
        for(int j=0; j<index; j++) {
            if (arr[j] <= 1000 && i%arr[j] == 0){
                count++;
            }
            if(count >= 2){
                break;
            }
        }
        if(count == 1){
            arr[index++] = i;
            if(i>=start){
                cout << i << '\n';
            }
        }
    }

}