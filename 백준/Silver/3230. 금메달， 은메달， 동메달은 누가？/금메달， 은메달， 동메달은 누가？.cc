#include <iostream>
#include <vector>
using namespace std;

int main(){
    int memberNum, roundTwo;
    cin >> memberNum >> roundTwo;

    int grade;
    vector<int> gradeVec;
    for(int i=1; i<=memberNum; i++){
        cin >> grade;
        gradeVec.insert(gradeVec.begin()+grade-1, i);
    }

    vector<int> twoGrade;
    for(int i=roundTwo; i > 0; i--){
        cin >> grade;
        twoGrade.insert(twoGrade.begin()+grade-1, gradeVec[i-1]);
    }

    for(int i=0; i<3; i++){
        cout << twoGrade.front();
        cout << "\n";
        twoGrade.erase(twoGrade.begin());
    }

    return 0;
}