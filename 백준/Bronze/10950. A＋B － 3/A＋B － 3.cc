#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int loop;
    cin >> loop;


   int maxInt=-10000000, minInt=10000000;
   int input1, input2;
   for(int i=0; i< loop; i++){
       cin >> input1 >> input2;
       int sum = input1 + input2;
       cout << sum << "\n";
   }




    return 0;
}