#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    
    int arr[4] = {0};
    for(int i=0; i<survey.size(); i++){
        switch(survey[i][0]){
            case 'R':
                arr[0] += 4-choices[i];
                break;
            case 'T':
                arr[0] -= 4-choices[i];
                break;
            case 'C':
                arr[1] += 4-choices[i];
                break;
            case 'F':
                arr[1] -= 4-choices[i];
                break;
            case 'J':
                arr[2] += 4-choices[i];
                break;
            case 'M':
                arr[2] -= 4-choices[i];
                break;
            case 'A':
                arr[3] += 4-choices[i];
                break;
            case 'N':
                arr[3] -= 4-choices[i];
                break;
        }
    }
    
    string answer = "";
    answer += arr[0] >= 0 ? "R" : "T";
    answer += arr[1] >= 0 ? "C" : "F";
    answer += arr[2] >= 0 ? "J" : "M";
    answer += arr[3] >= 0 ? "A" : "N";
    return answer;
}