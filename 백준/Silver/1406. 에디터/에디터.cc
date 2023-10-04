#include <iostream>
#include <string>
#include <list>
using namespace std;

int main(void){
    string s1;
    getline(cin, s1, '\n');

    list<char> li;
    for(int i=0; i<s1.length(); i++){
        li.push_back(s1[i]);
    }
    list<char>::iterator it = li.end();
    
    int controlTime;
    cin >> controlTime;
    char controlChar, newChar;

    while(controlTime--){
        cin >> controlChar;
        switch (controlChar)
        {
        case 'L':
            if(it != li.begin())
                it--;
            break;
        case 'D':
            if(it != li.end())
                it++;
            break;
        case 'B':
            if(it != li.begin())
                it = li.erase(--it);
            break;
        case 'P':
            cin >> newChar;
            li.insert(it, newChar);
            break;
        default:
            break;
        }
    }

    for(it = li.begin(); it != li.end(); it++){
        cout << *it;
    }

    return 0;
}