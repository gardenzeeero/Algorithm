#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int loop;
    cin >> loop;


    int count;
    string input;
    for(int i=0; i<loop; i++){
        cin >> count >> input;
        for(int i=0; i<input.length(); i++){
            for(int j=0; j<count; j++){
                cout << input[i];
            }
        }
        cout << "\n";
    }




    return 0;
}