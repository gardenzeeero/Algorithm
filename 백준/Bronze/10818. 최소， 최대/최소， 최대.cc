#include <iostream>
#include <string>
#include <map>
using namespace std;


int main(){
    int loop;
    cin >> loop;


   int maxInt=-10000000, minInt=10000000;
   int input;
   for(int i=0; i< loop; i++){
       cin >> input;
       if(input > maxInt) maxInt = input;
       if(input < minInt) minInt = input;
   }
   cout << minInt << " " <<  maxInt;




    return 0;
}