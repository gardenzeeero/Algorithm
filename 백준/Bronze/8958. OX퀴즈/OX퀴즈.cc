#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    string input;

    int loop;
    cin >> loop;
    for(int i=0; i<loop; i++){
        cin >> input;
        int sum = 0;
        int count = 0;
        for(int i=0; i<input.length(); i++) {
            if (input[i] == 'O') {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        cout << sum << "\n";
    }




}