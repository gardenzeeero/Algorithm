
#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int tryN;
    int x, y, tx, ty, n, count, s1, s2;
    int cx[50], cy[50], cr[50];
    
    
    cin >> tryN;
    while(tryN--){
        cin >> x >> y >> tx >> ty;
        cin >> n;
        count = 0;
        
        for(int i=0; i<n; i++){
            cin >> cx[i] >> cy[i] >> cr[i];
            s1 = sqrt((cx[i]-x)*(cx[i]-x) + (cy[i]-y)*(cy[i]-y));
            s2 = sqrt((cx[i]-tx)*(cx[i]-tx) + (cy[i]-ty)*(cy[i]-ty));
            if(cr[i] > s1 || cr[i] > s2){
                count++;
                if(cr[i] > s1 && cr[i] > s2){
                    count--;
                }
            }
        }
        cout << count << endl;
    }
    return 0;
}
