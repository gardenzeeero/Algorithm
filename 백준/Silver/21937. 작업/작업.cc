#include <iostream>
#include <vector>
#include <deque>
using namespace std;


int main(){
    int taskSize, condition;
    cin >> taskSize >> condition;

    int task1, task2;
    vector<int> arr[100001];
    for(int i=0; i<condition; i++){
        cin >> task1 >> task2;
        arr[task2].push_back(task1);
    }

    int target;
    int count=0;
    cin >> target;
    deque<int> d1;
    d1.push_back(target);

    bool visited[100001] = {false, };
    int top;
    while(!d1.empty()){
        top = d1.front();
        if(visited[top]){
            d1.pop_front();
            continue;
        }
        for(int i=0; i<arr[top].size(); i++){
            d1.push_back(arr[top][i]);
        }
        visited[top] = true;
        d1.pop_front();
        count++;
    }
    cout << --count;

}