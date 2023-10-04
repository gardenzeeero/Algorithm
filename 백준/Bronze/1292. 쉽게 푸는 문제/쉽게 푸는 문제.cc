#include <iostream>
using namespace std;

int main() {
    int start, end;
    int sum = 0;
    cin >> start;
    cin >> end;

    int arr[1001];
    int index = 1, count=1;
    while(index<=1001){
        for(int i=0; i<count; i++){
            arr[index++] = count;
            if(index>1001){
                break;
            }
        }
        count++;
    }

    for(int i=start; i<=end; i++){
        sum += arr[i];
    }
    cout << sum;

    return 0;
}
