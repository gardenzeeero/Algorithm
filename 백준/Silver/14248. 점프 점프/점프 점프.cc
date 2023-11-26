#include <iostream>
#include <vector>
using namespace std;

int count1 = 0;
int visited[100000] = {0, };
vector<int> stones[100000];

void dfs(int index){
    visited[index] = 1;
    for(int i=0; i<stones[index].size(); i++){
        if(visited[stones[index][i]] != 1){
            dfs(stones[index][i]);
        }
    }
}

int main(){
    int stone, input;

    cin >> stone;
    for(int i=1; i<=stone; i++){
        cin >> input;
        if(i-input >= 1){
            stones[i].push_back(i-input);
        }
        if(i+input <= stone){
            stones[i].push_back(i+input);
        }
    }

    int now;
    cin >> now;
    dfs(now);


    for(int i=1; i<= stone; i++){
        if(visited[i] == 1){
            count1++;
        }
    }

    cout << count1;
    return 0;
}