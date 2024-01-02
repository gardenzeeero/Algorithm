#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int hole, action;
vector<int> plugged;
vector<int> turn;

bool check(int input, int index){
    for(int i=0; i<hole; i++){
        if(plugged[i] == input){
            return true;
        }
    }

    for(int i=0; i<hole; i++){
        if(plugged[i] == 0){
            plugged[i] = input;
            return true;
        }
    }

    int unplug=0, lastIdx=-1;
    for(int i=0; i<hole; i++){
        int firstIdx = 1000;
        for(int j = index+1; j<turn.size(); j++){
            if(plugged[i] == turn[j]){
                firstIdx = j;
                break;
            }
        }

        if(lastIdx < firstIdx){
            unplug = i;
            lastIdx = firstIdx;
        }
    }

    plugged[unplug] = input;
    return false;
}

int main() {
    cin >> hole >> action;
    for(int i=0; i<hole; i++){
        plugged.push_back(0);
    }


    int input, total = 0;
    for (int i = 0; i < action; i++) {
        cin >> input;
        turn.push_back(input);
    }

    for (int i = 0; i < action; i++) {
        if (!check(turn[i], i)){
            total++;
        }
    }

    cout << total;



    return 0;
}



//#include <iostream>
//#include <queue>
//#include <vector>
//using namespace std;
//
//int hole, action;
//vector<int> plugged;
//int electro[101] = {0, };
//
//bool check(int input){
//    for(int i=0; i<hole; i++){
//        if(plugged[i] == input){
//            return true;
//        }
//    }
//
//    for(int i=0; i<hole; i++){
//        if(plugged[i] == 0){
//            plugged[i] = input;
//            return true;
//        }
//    }
//
//    int min = 0;
//    for(int i=0; i<hole; i++){
//         if(electro[plugged[i]] < electro[plugged[min]]){
//            min = i;
//        }
//    }
//    plugged[min] = input;
//    return false;
//}
//
//int main() {
//    cin >> hole >> action;
//    for(int i=0; i<hole; i++){
//        plugged.push_back(0);
//    }
//    queue<int> q;
//
//    int input, total = 0;
//    for (int i = 0; i < action; i++) {
//        cin >> input;
//        electro[input]++;
//        q.push(input);
//    }
//
//    for (int i = 0; i < action; i++) {
//        input = q.front();
//        q.pop();
//        electro[input]--;
//        if (!check(input)){
//            total++;
//        }
//    }
//
//    cout << total;
//
//
//
//    return 0;
//}