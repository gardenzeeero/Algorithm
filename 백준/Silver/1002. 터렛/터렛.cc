//
//  main.cpp
//  cpp강의
//
//  Created by 정원영 on 2023/03/19.
//

#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int count=0, t_case;
    int x1, y1, r1, x2,y2, r2, rp, rm;
    int tx, ty;
    double s;
    
    cin >> t_case;
    while(count < t_case){
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        s = sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        rp = r1 + r2;
        rm = abs(r1-r2);
       
        if(s == 0){
            if(r1 == r2 && r1 != 0){
                cout << -1 << endl;
            }
            else if(r1 == r2){
                cout << 1 << endl;
            }
            else if(r1 != r2){
                cout << 0 << endl;
            }
        }
        else if(s < rp){
            if(rm == s){
                cout << 1 << endl;
            }
            else if(rm > s){
                cout << 0 << endl;
            }
            else if(rm < s){
                cout << 2 << endl;
            }
        }
        else if(s > rp){
            cout << 0 << endl;
        }
        else if(s == rp){
            cout << 1 << endl;
        }
                
        count++;
    }
}
